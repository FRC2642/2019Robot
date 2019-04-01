/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.drive.DriveCommand;
import frc.library.lib.pid.PIDOutput;
import frc.library.lib.pid.PIDSource;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public TalonSRX leftFrontMaster, leftRearSlave;
public TalonSRX rightFrontMaster, rightRearSlave;

PigeonIMU pigeon = new PigeonIMU(RobotMap.ID_PIGEON);

public AHRS navx = new AHRS(SPI.Port.kMXP);

private boolean isDriveStraight = true;

public boolean isWorking = false;

public DriveSubsystem(){
  leftFrontMaster = new TalonSRX(RobotMap.ID_LEFT_FRONT_DRIVE);
  leftRearSlave = new TalonSRX(RobotMap.ID_LEFT_REAR_DRIVE);
  rightFrontMaster = new TalonSRX(RobotMap.ID_RIGHT_FRONT_DRIVE);
  rightRearSlave = new TalonSRX(RobotMap.ID_RIGHT_REAR_DRIVE);
  PigeonIMU pigeon = new PigeonIMU(RobotMap.ID_PIGEON);

  //gyro calibration
  pigeon.enterCalibrationMode(CalibrationMode.BootTareGyroAccel);
  pigeon.enterCalibrationMode(CalibrationMode.Temperature);

  //set master-slave motors
  leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
  rightRearSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());

  //set limit stuff
  leftFrontMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
  leftFrontMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
  leftFrontMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
  leftFrontMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
  //set voltage comp stuff
  rightFrontMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
  rightFrontMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
  rightFrontMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
  rightFrontMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
  //set neutral deadband
  rightFrontMaster.configNeutralDeadband(.1);
  leftFrontMaster.configNeutralDeadband(.1);
 // rightFrontMaster.setInverted(true);
 // leftFrontMaster.setInverted(true);

}

  public void setLeftSpeed(double speed) {
  leftFrontMaster.set(ControlMode.PercentOutput, speed);
}

public void setRightSpeed(double speed){
  rightFrontMaster.set(ControlMode.PercentOutput, speed);
}

public void stop(){
  setLeftSpeed(0);
  setRightSpeed(0);
}

public void arcadeDrive(double speed, double turn) {
  turn = -turn;
  leftFrontMaster.set(ControlMode.PercentOutput, turn, DemandType.ArbitraryFeedForward, speed);
  rightFrontMaster.set(ControlMode.PercentOutput, turn, DemandType.ArbitraryFeedForward, -speed);
}

public void tankDrive(double left, double right){
  setLeftSpeed(left);
  setRightSpeed(right);
}



  //classes for inbuilt PID
    public class TapePID implements PIDSource{

    @Override
    public double pidGet() {
      return pigeon.getAbsoluteCompassHeading();
    }
  }
  public class TapeOutput implements PIDOutput{

    double output;
    @Override
    public void pidSet(double speed) {
      output = speed;
    }
    
    public double getOutput(){
      return output;
    }
  }



  public double getEncoderLeft(){
		System.out.println(leftFrontMaster.getSelectedSensorPosition());
		return leftFrontMaster.getSelectedSensorPosition();
	}
	
	public double getEncoderRight(){
    System.out.println(rightFrontMaster.getSelectedSensorPosition());
    return rightFrontMaster.getSelectedSensorPosition();
  	}
	
	public void resetBothEncoders(){
    leftFrontMaster.setSelectedSensorPosition(0);
    rightFrontMaster.setSelectedSensorPosition(0);
	}
	
	//Returns a given encoder value as inches
	public double encoderInches(double encoderValue){
		return encoderValue / 12.9;
	}
	
	//Returns the left encoder distance as inches
	public double leftEncoderInches(){
		return encoderInches(getEncoderLeft());
	}
	
	public double rightEncoderInches(){
		return encoderInches(getEncoderRight());
	}
	
	public double setDegrees(double degrees){
		return degrees * -0.26;
	}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }

//Drives straight in autonomous with PID control
public void driveStraight(double speed){
  double correction = 0.0;
  //Checks to see if the difference between the left and right is within a margin of error
  if(Math.abs(leftEncoderInches() - rightEncoderInches()) > RobotMap.driveForwardOffset){	
    //Left distance is less than right distance
    if(leftEncoderInches() < rightEncoderInches()){
      correction = -RobotMap.driveCorrection;
    }else{	//Right distance is less than left distance
      correction = RobotMap.driveCorrection;
    }
  }
  arcadeDrive(-speed, correction);	//Drives with the correction value
}

//Turns in autonomous with PID control
public void driveTurn(double speed){
  double correctionL = 0.0;
  double correctionR = 0.0;
  //Checks to see if the difference between the left and right is within a margin of error
  if(Math.abs(leftEncoderInches() + rightEncoderInches()) > RobotMap.driveForwardOffset){
    if(leftEncoderInches() > rightEncoderInches())	//Left distance is greater than right distance
      correctionR = -RobotMap.driveCorrection;
    }else{
      correctionL = -RobotMap.driveCorrection;
    }
  tankDrive(-speed - correctionL, speed - correctionR);	//Drives as a tank drive to correct turning drift
}

public void setIsDriveStraight(boolean state){
  isDriveStraight = state;
}

protected double returnPIDInput() {
  if(isDriveStraight)
    return (rightEncoderInches() + leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
  else
    return (rightEncoderInches() - leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
}


}
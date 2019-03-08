/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import com.ctre.phoenix.sensors.PigeonImuJNI;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.drive.DriveCommand;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public TalonSRX leftFrontMaster, leftRearSlave;
public TalonSRX rightFrontMaster, rightRearSlave;

DigitalInput lightSensor = new DigitalInput(RobotMap.lightSensorPort);

PigeonIMU pigeon = new PigeonIMU(RobotMap.ID_PIGEON);

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

public void turn(double turn){
  setLeftSpeed(turn);
  setRightSpeed(turn);
}

public boolean getLightSensor(){
  return lightSensor.get();
}

public double getPigeonHeading(){
  return pigeon.getAbsoluteCompassHeading();
}

public boolean work(boolean isWorking){
  if(!this.isWorking){
    this.isWorking = isWorking;
  } else{
    System.out.println("You already work tf?");
  }
  System.out.println("Working? " + this.isWorking);
  return this.isWorking;
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
	}
	
	// reset encoders for the start of auto
	//just sets to 0, does not move
	public void resetEncoders() {
		leftFrontMaster.setSelectedSensorPosition(0, 0, 0);
		rightFrontMaster.setSelectedSensorPosition(0, 0, 0);
	}

	//sets P
	public void setkP(double _kP) {
		rightFrontMaster.config_kP(0, _kP, 0);
		leftFrontMaster.config_kP(0, _kP, 0);
	}
	//sets I
	public void setkI(double _kI) {
		rightFrontMaster.config_kI(0, _kI, 0);
		leftFrontMaster.config_kI(0, _kI, 0);
	}
	//sets D
	public void setkD(double _kD) {
		rightFrontMaster.config_kD(0, _kD, 0);
		leftFrontMaster.config_kD(0, _kD, 0);
	}
	//Set F
	public void setkF(double _kF_L, double kF_R) {
		leftFrontMaster.config_kF(0, _kF_L, 0);
		rightFrontMaster.config_kF(0, kF_R, 0);
	}
	//cruising velocity for motion profiling
	public void setMotnCV(int vcruise) {
		rightFrontMaster.configMotionCruiseVelocity(vcruise, 0);
		leftFrontMaster.configMotionCruiseVelocity(vcruise, 0);
	}
	//standard acceleration for motion profiling
	public void setMotnAccel(int accel) {
		rightFrontMaster.configMotionAcceleration(accel, 0);
		leftFrontMaster.configMotionAcceleration(accel, 0);
	}

	//methods for finding pulse equal to distance
	public double getRightDistance() {
		return rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PER_PULSE;
	}

	public double getLeftDistance() {
		return leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DISTANCE_PER_PULSE;
	}
	//full send on motion profiling
	public double getRightSpeed() {
		return 10 * rightFrontMaster.getSelectedSensorVelocity(0) * RobotMap.DISTANCE_PER_PULSE;
	}

	public double getLeftSpeed() {
		return 10 * leftFrontMaster.getSelectedSensorVelocity(0) * RobotMap.DISTANCE_PER_PULSE;
	}

	public int getLeftEncoder() {
		return leftFrontMaster.getSelectedSensorPosition(0);
	}

	public int getRightEncoder() {
		return rightFrontMaster.getSelectedSensorPosition(0);
	}

	public void resetGyro() {
		pigeon.setYawToCompass(0);
		pigeon.setCompassAngle(0);
	}

	public void gyroCalibration(){
		pigeon.enterCalibrationMode(CalibrationMode.BootTareGyroAccel);
		pigeon.enterCalibrationMode(CalibrationMode.Temperature);
	}

	public void resetMP(){
		leftFrontMaster.clearMotionProfileTrajectories();
		rightFrontMaster.clearMotionProfileTrajectories();
	}


	public void SetMPBuffer(){
		BufferedTrajectoryPointStream bufferedStream = new BufferedTrajectoryPointStream();
	}


	public void talonFactoryDefault(){
		leftFrontMaster.configFactoryDefault();
	}
	public void configAll(){
		
		TalonSRXConfiguration config = new TalonSRXConfiguration();

		config.remoteFilter0.remoteSensorDeviceID = pigeon.getDeviceID();
        config.remoteFilter0.remoteSensorSource = RemoteSensorSource.Pigeon_Yaw;
        /* remote 1 will capture the quad encoder on left talon */
        config.remoteFilter1.remoteSensorDeviceID = leftFrontMaster.getDeviceID();
        config.remoteFilter1.remoteSensorSource = RemoteSensorSource.TalonSRX_SelectedSensor;
        /* drive-position  is our local quad minus left-talon's selected sens.  
            depending on sensor orientation, it could be the sum instead */
        config.diff0Term = FeedbackDevice.QuadEncoder;
        config.diff1Term = FeedbackDevice.RemoteSensor1;
        config.primaryPID.selectedFeedbackSensor = FeedbackDevice.SensorDifference;
        config.primaryPID.selectedFeedbackCoefficient = 0.5; /* divide by 2 so we servo sensor-average, intead of sum */
        /* turn position will come from the pigeon */
        config.auxiliaryPID.selectedFeedbackSensor = FeedbackDevice.RemoteSensor0;
        /* rest of the configs */
        config.neutralDeadband = RobotMap.deadband; /* 0.1 % super small for best low-speed control */
        config.slot0.kF = RobotMap.kGains_MotProf.kF;
        config.slot0.kP = RobotMap.kGains_MotProf.kP;
        config.slot0.kI = RobotMap.kGains_MotProf.kI;
        config.slot0.kD = RobotMap.kGains_MotProf.kD;
        config.slot0.integralZone = (int) RobotMap.kGains_MotProf.kIzone;
        config.slot0.closedLoopPeakOutput = RobotMap.kGains_MotProf.kPeakOutput;
        // config.slot0.allowableClosedloopError // leave default
        // config.slot0.maxIntegralAccumulator; // leave default
        // config.slot0.closedLoopPeriod; // leave default
        config.slot1.kF = RobotMap.kGains_MotProf.kF;
        config.slot1.kP = RobotMap.kGains_MotProf.kP;
        config.slot1.kI = RobotMap.kGains_MotProf.kI;
        config.slot1.kD = RobotMap.kGains_MotProf.kD;
        config.slot1.integralZone = (int) RobotMap.kGains_MotProf.kIzone;
        config.slot1.closedLoopPeakOutput = RobotMap.kGains_MotProf.kPeakOutput;
        // config.slot1.allowableClosedloopError // leave default
        // config.slot1.maxIntegralAccumulator; // leave default
        // config.slot1.closedLoopPeriod; // leave default
		rightFrontMaster.configAllSettings(config);
	}
	public void setFollowerMode(){
		rightFrontMaster.follow(leftFrontMaster, FollowerType.AuxOutput1);
	}
	
	public void yeetFollowerMode(){
		leftFrontMaster.set(ControlMode.PercentOutput, 1);
		rightFrontMaster.set(ControlMode.PercentOutput, 1);
	}
	public void setRightDistMotion(double distance) {
		rightFrontMaster.set(ControlMode.MotionMagic, distance);
	}
	//method for calling the distance to a certain point right
	public void setLeftDistMotion(double distance) {
		leftFrontMaster.set(ControlMode.MotionMagic, distance);
	}
	public ErrorCode getRawGyro(double[] xyz_dps) {
		//temp
		long m_handle = 0;
		int retval = PigeonImuJNI.JNI_GetRawGyro(m_handle, xyz_dps);
		return ErrorCode.valueOf(retval);
	}
}
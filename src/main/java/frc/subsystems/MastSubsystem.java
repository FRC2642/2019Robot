/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.mast.LiftCommand;
import frc.robot.RobotMap;


/**
 * This system runs the mast up and down.
 * This allows the robot to place game pieces at the upper levels.
 */
public class MastSubsystem extends Subsystem {

  public TalonSRX mastMaster = new TalonSRX(RobotMap.ID_MAST_MASTER);
  public TalonSRX mastSlave = new TalonSRX(RobotMap.ID_MAST_SLAVE);

  public Solenoid mastCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.mastCylinderPort);

  public Encoder mastEncoder = new Encoder(RobotMap.mastEncoderA, RobotMap.mastEncoderB, false, Encoder.EncodingType.k4X);
  public DigitalInput mastUpperLimitSwitch = new DigitalInput(RobotMap.mastUpperLimitSwitchPort);
  public DigitalInput mastLowerLimitSwitch = new DigitalInput(RobotMap.mastLowerLimitSwitchPort);

  public MastSubsystem(){
    mastSlave.set(ControlMode.Follower, mastMaster.getDeviceID());

  //limit settings
  mastMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
  mastMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
  mastMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
  mastMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
  //deadband settings
  mastMaster.configNeutralDeadband(.1);
  }

   //mast motor methods

  public void moveLift(double speed) {

    if(speed < 0 && !getUpperLimitSwitch()) {
      stop();
    } else if(speed > 0 && !getLowerLimitSwitch()) {
      stop();
    } else if(speed > 0){
      mastMaster.set(ControlMode.PercentOutput, speed * .2);
    /*
    } else if(speed > 0){
      double s = !getLowerLimitSwitch() ? speed * .2 : 0;
      mastMaster.set(ControlMode.PercentOutput, s);
      */
    } else {
      mastMaster.set(ControlMode.PercentOutput, speed);
      }
    }

  public void stop(){
    mastMaster.set(ControlMode.PercentOutput, 0);
  }

  public double getMastPercentOutput(){
    double output = mastMaster.getMotorOutputPercent();
    return output;
  }

  //mast cylinder methods

  public void mastCylinderUp(){
    mastCylinder.set(true);
  }

  public void mastCylinderDown(){
    mastCylinder.set(false);
  }

  public boolean getMastCylinder(){
    return mastCylinder.get();
  }

  //sensor related methods
    
  protected double returnPIDInput() {
    return mastEncoder.pidGet();
  }

  protected void usePIDOutput(double output) {
    moveLift(output);
  }
  
  public void resetEncoder(){
    mastEncoder.reset();
  }
  
  public boolean getUpperLimitSwitch(){
    return mastUpperLimitSwitch.get();
  }

  public boolean getLowerLimitSwitch(){
    return mastLowerLimitSwitch.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftCommand());
  }
}





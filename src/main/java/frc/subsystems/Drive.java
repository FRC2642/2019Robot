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

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.DriveCommand;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public TalonSRX leftFrontMaster, leftRearSlave;
public TalonSRX rightFrontMaster, rightRearSlave;

public boolean isWorking = false;

public Drive(){
  leftFrontMaster = new TalonSRX(RobotMap.ID_LEFT_FRONT);
  leftRearSlave = new TalonSRX(RobotMap.ID_LEFT_REAR);
  rightFrontMaster = new TalonSRX(RobotMap.ID_RIGHT_FRONT);
  rightRearSlave = new TalonSRX(RobotMap.ID_RIGHT_REAR);

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

  

}

public void setLeftSpeed(double speed){
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
}
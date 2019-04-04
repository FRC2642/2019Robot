/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.mast;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.library.lib.pid.PID;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class MoveMastToCameraHeight extends Command {
  public MoveMastToCameraHeight() {
    // requires
    requires(Robot.mast);
  }

  Timer timer = new Timer();
  PID pid = new PID(Robot.mast, Robot.mast, RobotMap.MAST_PARAMS);

  boolean hitSetpoint = false;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    pid.enable();
    pid.setSetpoint(RobotMap.mastHatchHeight);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.mast.mastCylinderUp();
    //Robot.mast.setToVisionHeight();
    /*
    if(Robot.mast.pidGet() > RobotMap.mastCameraHeight){
      Robot.mast.pidSet(-0.2);
    }else if(Robot.mast.pidGet() < RobotMap.mastCameraHeight){
      Robot.mast.pidSet(0.2);
    }else if(Robot.mast.pidGet() == RobotMap.mastCameraHeight){
      Robot.mast.pidSet(0);
    }
    */
    if(!hitSetpoint && (Robot.mast.pidGet() >= -2 && Robot.mast.pidGet() <= 2)){
      timer.start();
      hitSetpoint = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (timer.get() >= 1);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mast.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mast.stop();
  }
}

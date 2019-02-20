/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.util;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class DisableLimitsCommand extends Command {
  public DisableLimitsCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  //state of enabled limits
  static boolean state = true;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(state){
    RobotMap.isMastLimitEnabled = false;
    RobotMap.isWristLimitEnabled = false;
    }
    if(!state){ 
    RobotMap.isMastLimitEnabled = true;
    RobotMap.isWristLimitEnabled = true;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    state = !state;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

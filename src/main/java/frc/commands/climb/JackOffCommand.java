/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.climb;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class JackOffCommand extends Command {
  public JackOffCommand() {
    //requires
    requires(Robot.climb);
  }

  boolean hasRun = false;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.stopJack();
    hasRun = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return hasRun;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climb.stopJack();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climb.stopJack();
  }
}
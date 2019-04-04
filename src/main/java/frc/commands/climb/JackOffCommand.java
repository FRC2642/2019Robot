/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.climb;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class JackOffCommand extends Command {
  public JackOffCommand() {
    //requires
    requires(Robot.climb);
  }

  Timer timer = new Timer();
  boolean hasTimerStarted = false;
  boolean hasRun = false;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.stopJack();
    if(!hasTimerStarted) {
      timer.start();
      hasTimerStarted = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timer.get() >= 1;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    timer.stop();
    Robot.climb.stopJack();
    Robot.climb.disablePID();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climb.stopJack();
  }
}

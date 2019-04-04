/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.climb;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ManualClimbCommand extends Command {
  public ManualClimbCommand() {
    // requires
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //right stick (front jack)
    if(OI.xbox.getRawAxis(5) > .5){
      Robot.climb.moveFrontClimbDown();
    } else if(OI.xbox.getRawAxis(5) < -.5){
      Robot.climb.moveFrontClimbDown();
    } else {
      Robot.climb.stopFrontClimb();
    }

    //D-Pad (back jack)
    if(OI.xbox.getPOV() == 0){
      Robot.climb.jackUp();
    } else if(OI.xbox.getPOV() == 180){
      Robot.climb.jackDown();
    } else {
      Robot.climb.stopJack();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climb.stopJack();
    Robot.climb.stopFrontClimb();
  }
}

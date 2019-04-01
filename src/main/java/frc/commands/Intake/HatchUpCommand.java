/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchUpCommand extends Command {
  public HatchUpCommand() {
    // Use requires() here to declare subsystem dependencies
  requires(Robot.hatch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   /* if(OI.aux.getRawButton(4)){
     Robot.hatch.hatchUp();
    } else if(OI.aux.getRawButton(3)){
     Robot.hatch.hatchDown();
    }*/
    Robot.hatch.set();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatch.hatchDown();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.hatch.hatchDown();
  }
}

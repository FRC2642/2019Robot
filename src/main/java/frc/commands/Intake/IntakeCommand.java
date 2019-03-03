/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class IntakeCommand extends Command {
 
    public IntakeCommand() {
      requires(Robot.intake);
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   
    if(OI.aux.getRawAxis(2) > .6){
      Robot.intake.intake();
    } else if(OI.aux.getRawAxis(3) > .6){
      Robot.intake.outtake();
    } else {
      Robot.intake.stop();
    }
  }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.intake.limitSwitchState();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.intake.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      Robot.intake.stop();
  }
}

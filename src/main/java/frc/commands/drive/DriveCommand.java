/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(OI.xbox.getRawAxis(3) > .6){
      Robot.drive.arcadeDrive(-OI.xbox.getRawAxis(1), -OI.xbox.getRawAxis(0));
    } else {
    Robot.drive.arcadeDrive((-OI.xbox.getRawAxis(1)) * 0.6, (-OI.xbox.getRawAxis(0)));
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if x axis is being held down, end drive command
   /* if(OI.xbox.getRawAxis(0) > 0.1 || OI.xbox.getRawAxis(0) < -0.1){
      return true;
    } else {*/
      return false;
    //}
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
   
  }
}

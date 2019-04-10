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
    //requires
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //slow drive for precision
    if(isLeftTriggerPulled()){
      Robot.drive.arcadeDrive(-OI.xbox.getRawAxis(1) * .4,-(OI.xbox.getRawAxis(0) * .2));
    }
    //fast drive, sicko
    else if(isRightTriggerPulled()){
      Robot.drive.arcadeDrive(-OI.xbox.getRawAxis(1) * .96,-(OI.xbox.getRawAxis(0) * .58));
    }
    //normal drive
    else{
      Robot.drive.arcadeDrive(-OI.xbox.getRawAxis(1) * .7,-(OI.xbox.getRawAxis(0) * .48));
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
    Robot.drive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
   Robot.drive.stop();
  }

  public boolean isLeftTriggerPulled() {
    if(OI.xbox.getRawAxis(2) > .5){
      return true;
    } else {
      return false;
    }
  }

  public boolean isRightTriggerPulled(){
    if(OI.xbox.getRawAxis(3) > .5) {
      return true;
    } else {
      return false;
    } 
  }
  
}

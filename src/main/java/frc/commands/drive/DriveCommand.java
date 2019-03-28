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
    //Fast Turn, fast straight 
    if(isLeftTriggerPulled()){
      Robot.drive.arcadeDrive(-OI.xbox.getRawAxis(1) * .96,-(OI.xbox.getRawAxis(0) * .80));
    }
    //slower turn, fast straight
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

  public boolean isLeftTriggerPulled() {
    if(OI.xbox.getRawAxis(2) > .5){
      return true;
    }
    else{
      return false;
    }
  
  }

  public boolean isRightTriggerPulled(){
    if(OI.xbox.getRawAxis(3) > .5) {
      return true;
    }
    else{
      return false;
    }
  }


}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PressCupsCommand extends Command {
  public PressCupsCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }
    //state of cups  
  //false = up, true = down
  static boolean state = true;
  
  static boolean hasRun = false;
  

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   /* if(!state){
      Robot.intake.deactivateSucc();
      state = !state;
      hasRun = !hasRun;

    } else {
      Robot.intake.activateSucc();
      state = !state;
      hasRun = !hasRun; 
     } */
     Robot.intake.activateSucc();
     hasRun = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(hasRun){
      return true;
    } else {
    return false;
    }
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

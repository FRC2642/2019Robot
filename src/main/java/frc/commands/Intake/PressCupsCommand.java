/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class PressCupsCommand extends Command {
  public PressCupsCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intake);
  }
    //state of cups  
  //false = up, true = down
  static boolean state = false;
  boolean hasRun;

  Timer timer = new Timer();

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
    hasRun = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(timer.get() > 1){
      timer.stop();
    }

    if(!state && timer.get() > .5){
      Robot.intake.deactivateSucc();
      state = !state;
      timer.reset();
      hasRun = true;

    } 
    if(state && timer.get() > .5){
      Robot.intake.activateSucc();
      state = !state;
      timer.reset();
      hasRun = true;
     } 
     
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return hasRun;
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

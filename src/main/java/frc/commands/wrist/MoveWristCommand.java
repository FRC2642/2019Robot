/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.wrist;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class MoveWristCommand extends Command {
  public MoveWristCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.wrist);
  }
/*
  //state of wrist piston
  //false = in, true = out
  static boolean pistonState = false;
  boolean hasRun;

  Timer timer = new Timer();
*/
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  //  timer.start();
   
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*
    //prevent timer for running forever when intake not running
    if(timer.get() > 1){
      timer.stop();
    }

    if(OI.aux.getRawAxis(3) > .6 && timer.get() > .5) {
      if(!pistonState){
      Robot.wrist.wristOut();
      pistonState = !pistonState; 
      timer.reset();
      hasRun = true;
      }
      if(pistonState){
      Robot.wrist.wristIn();
      pistonState = !pistonState;
      timer.reset();
      hasRun = true;
      }
    }*/
      
    if(OI.aux.getRawAxis(1) > .25 || OI.aux.getRawAxis(1) < -.25){
        Robot.wrist.moveWrist(OI.aux.getRawAxis(1) * .9);
    } else {
      Robot.wrist.stop();
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
  }
}

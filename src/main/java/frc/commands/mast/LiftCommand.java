/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.mast;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class LiftCommand extends Command {
  public LiftCommand() {
   requires(Robot.brake);
   requires(Robot.mast);
  }

  //state of brake
  //false = not engaged, true = engaged
  static boolean state = false;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   state = Robot.brake.getBrakeCylinderState();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    //if joystick is pressed down, run this
    if(OI.aux.getRawAxis(5) < -.25 || OI.aux.getRawAxis(5) > .25){
      //if brake is engaged, disengage brake and switch state
      if(state){
        Robot.brake.brakeOff();

        if(Robot.brake.getBrakeCylinderState()){
        state = !state;
        }
      }
      //move mast using joystick input
      Robot.mast.moveLift((OI.aux.getRawAxis(5)) * 0.6);
    }
  
    //if joystick is NOT held down, run this
    if(OI.aux.getRawAxis(5) > -.25 && OI.aux.getRawAxis(5) < .25){
      //if brake isn't engaged, engage brake and switch state
      if(!state){
        Robot.brake.brakeOn();

        if(Robot.brake.getBrakeCylinderState()){
          state = !state;
      }
    }
      //don't move mast
      Robot.mast.stop();
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
    Robot.mast.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.mast.stop();
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.brake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class BrakeCommand extends Command {
  public BrakeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.brake);
  }

  Timer onTimer = new Timer();
  Timer offTimer = new Timer();

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //check if mast is not moving
    if(!Robot.brake.isMastMoving()){
      //if ^ met, start delay timer
      onTimer.start();
      //check if mast moves before delay is met 
      if(Robot.brake.isMastMoving()){
        //if ^ met, reset delay timer
        onTimer.reset();
      }
      //check if delay is met and if brake is not engaged
      if(onTimer.get() > .4 && !Robot.brake.getBrakeCylinderState()) {
        //if ^ met, engage brake
        Robot.brake.brakeOn();
      }
    }
    //separately check if mast is moving 
    if(Robot.brake.isMastMoving()){
      //if ^ met, start delay timer
      offTimer.start();
      //check if mast stops moving before delay is met 
      if(!Robot.brake.isMastMoving()){
        //if ^ met, reset delay timer
        offTimer.reset();
      }
      //check if delay is met and if brake is engaged
      if(offTimer.get() > .4 && Robot.brake.getBrakeCylinderState()) {
        //if ^ met, disengage brake
        Robot.brake.brakeOff();
      }
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
    Robot.brake.brakeOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.brake.brakeOff();
  }
}

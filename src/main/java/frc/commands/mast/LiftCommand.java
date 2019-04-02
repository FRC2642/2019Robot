/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.mast;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class LiftCommand extends Command {
  public LiftCommand() {
    //requires
    requires(Robot.mast);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //soon
   /* if(OI.aux.getRawAxis(1) > .5){
      Robot.mast.moveLift(.5);
    } else if(OI.aux.getRawAxis(1) < -.5){
      Robot.mast.moveLift(-.5);
    } else {*/
    Robot.mast.moveLift(OI.aux.getRawAxis(5) * .9);
   // }

    if(OI.aux.getBumperPressed(Hand.kLeft)){
      Robot.mast.mastCylinderDown();
    } else if(OI.aux.getBumperPressed(Hand.kRight)){
      Robot.mast.mastCylinderUp();
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

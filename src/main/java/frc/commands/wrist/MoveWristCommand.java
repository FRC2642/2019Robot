/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.wrist;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class MoveWristCommand extends Command {
  public MoveWristCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.wrist);
  }

  //state of wrist piston
  //false = in, true = out
  static boolean inOutState = false;
  //state of wrist motor
  //false = up, true = down
  static boolean upDownState = false;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(OI.aux.getRawAxis(3) > .6 && !inOutState){
      Robot.wrist.wristOut();
      inOutState = !inOutState;
    } else if(OI.aux.getRawAxis(3) > .6 && inOutState){
      Robot.wrist.wristIn();
      inOutState = !inOutState;
    }

    if(OI.aux.getRawAxis(2) > .6 && !upDownState){
      Robot.wrist.moveWristDown();
    } else if(OI.aux.getRawAxis(2) > .6 && upDownState){
      Robot.wrist.moveWristUp();
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
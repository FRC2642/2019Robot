/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.fangs;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FangsDeploy extends Command {
  public FangsDeploy() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.fang);
  }

  //state of fangs 
  //false = in, true = out
  static boolean state = false;

  static boolean hasRun = false;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  /*  if(state){
    Robot.fang.fangsIn();
    state = !state;
    hasRun = !hasRun;
  } else {
    Robot.fang.fangsOut();
    state = !state;
    hasRun = !hasRun;
   }*/
   Robot.fang.fangsOut();

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      if(hasRun){
        return true;
      }else{
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

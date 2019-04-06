/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.commands.auto.vision.TargetInfo;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveAtTarget extends Command {
  double timeout;
	
  public void DriveAtPeg(double timeout) {
    requires(Robot.drive);
    this.timeout = timeout;
  }
  

  protected void initialize() {
    setTimeout(timeout);
  }

  
  protected void execute() {
    if(TargetInfo.getNumTargets() == 1){
      if(TargetInfo.gettargetCenterX() > 0){
        Robot.drive.arcadeDrive(0, RobotMap.driveCorrection);
      }else{
        Robot.drive.arcadeDrive(0, -RobotMap.driveCorrection);
      }
    }else{
      //Gear center is outside of the offset area
      if(Math.abs(TargetInfo.gettargetCenterX()) > RobotMap.driveForwardOffset){
        //Too far 
        if(TargetInfo.gettargetCenterX() < -5){
          Robot.drive.arcadeDrive(RobotMap.driveForwardOffset, -RobotMap.driveCorrection);
        }
        if(TargetInfo.gettargetCenterX() > 5){
          Robot.drive.arcadeDrive(RobotMap.driveForwardOffset, RobotMap.driveCorrection);
        }
      }else{
        Robot.drive.arcadeDrive(RobotMap.driveCorrection, 0.0);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return !OI.xbox.getRawButton(1);
  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.drive.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    Robot.drive.stop();
  }

}

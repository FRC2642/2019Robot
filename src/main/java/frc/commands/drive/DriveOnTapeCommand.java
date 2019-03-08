/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.library.lib.pid.PID;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.subsystems.DriveSubsystem.TapeOutput;
import frc.subsystems.DriveSubsystem.TapePID;
import edu.wpi.first.wpilibj.Timer;

public class DriveOnTapeCommand extends Command {

  TapePID source = Robot.drive.new TapePID();
  TapeOutput output = Robot.drive.new TapeOutput();
  PID pid = new PID(source, output, RobotMap.TAPE_DRIVE_PARAMS);

  Timer timer = new Timer();

  double leftSpeed;
  double rightSpeed;
  double speed = .7;

  //starts with pseudo-setpoint
  //when on tape for good amount of time, makes actual setpoint
  boolean hasRealSetpoint = false;

  public DriveOnTapeCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    pid.setSetpoint(source.pidGet()); 
    pid.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if(Robot.drive.getLightSensor() && timer.get() == 0.0){
      timer.start();
    }
    if(Robot.drive.getLightSensor() && timer.get() == .7){
      pid.setSetpoint(source.pidGet());
      timer.stop();
    }

    if(!Robot.drive.getLightSensor()){
      timer.reset();

      double correction = output.getOutput();
      leftSpeed = speed - correction;
      rightSpeed = speed + correction;
    } else {
      leftSpeed = speed;
      rightSpeed = speed;
    }
    Robot.drive.tankDrive(leftSpeed, rightSpeed);
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
    Robot.drive.stop();
  }
}

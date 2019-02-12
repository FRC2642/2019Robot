/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.Thrust;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

public class ThrustCommand extends Command {
  private BaseMotorController rollerMaster;
  private BaseMotorController jackMaster;

  public ThrustCommand() {
    requires(Robot.thrust);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    rollerMaster.set(ControlMode.PercentOutput, 0);
    jackMaster.set(ControlMode.PercentOutput, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    rollerMaster.set(ControlMode.PercentOutput, 0);

  }
}

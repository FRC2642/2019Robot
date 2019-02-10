/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IntakeCommand extends Command {
 
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    public IntakeCommand() {
      requires(Robot.intake);
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   
    //if speed excedes 0, perform outtake. If speed precedes 0, perform intake.
    if(Robot.oi.aux.getRawAxis() > 0.6) {
      Robot.intake.outtake();
    } else if(Robot.oi.aux.getRawAxis() < -0.6) {
      Robot.intake.intake();

    } else {
      Robot.intake.stop();
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
      Robot.intake.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      Robot.intake.stop();
  }
}

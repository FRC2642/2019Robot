package frc.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class StraightDrive extends Command {

	public double leftSpeed, rightSpeed;

	public StraightDrive(double _speed) {
		this(_speed, _speed);
	}

	public StraightDrive(double _leftSpeed, double _rightSpeed) {
		requires(Robot.drive);
		this.leftSpeed = _leftSpeed;
		this.rightSpeed = _rightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.setLeftSpeed(leftSpeed);
		Robot.drive.setRightSpeed(rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}

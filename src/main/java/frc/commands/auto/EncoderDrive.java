package frc.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class EncoderDrive extends Command {
//declares the one time margin of error in number readings
	public static final double MARGIN = 1;
//standard drive stuff lol
	double leftDistance, rightDistance;
	double leftSpeed, rightSpeed;

	public EncoderDrive(double _leftDistance, double _leftSpeed, double _rightDistance, double _rightSpeed) {
		requires(Robot.drive);

		this.leftDistance = _leftDistance;
		this.rightDistance = _rightDistance;
		this.leftSpeed = _leftSpeed;
		this.rightSpeed = _rightSpeed;
	}

	protected void initialize() {
		Robot.drive.resetEncoders();
	}

	protected void execute() {
		Robot.drive.setLeftSpeed(leftSpeed);
		Robot.drive.setRightSpeed(rightSpeed);
	}
//how off we were on the encoders with the margin
	protected boolean isFinished() {
		double leftError = Math.abs(Robot.drive.getLeftDistance() - leftDistance);
		double rightError = Math.abs(Robot.drive.getRightDistance() - rightDistance);
		
		return (leftError < MARGIN) && (rightError < MARGIN);
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
}

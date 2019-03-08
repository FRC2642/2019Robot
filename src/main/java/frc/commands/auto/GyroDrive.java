package frc.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class GyroDrive extends Command {

	private double kP;
	private double speed;
	private double dist;

	int i = 0;

	/**
	 * @param _kP
	 *            The proportional feedback constant
	 * @param _dist
	 *            The distance to drive
	 * @param _speed
	 *            The base speed the robot will drive
	 */
	public GyroDrive(double _kP, double _dist, double _speed) {
		this.kP = _kP;
		this.dist = _dist;
		this.speed = _speed;
		requires(Robot.drive);
	}

	public GyroDrive(double _dist) {
		this(-0.04, _dist, -0.4); // Construct with default values
	}
	
	public GyroDrive(double _dist, double _speed) {
		this(-0.04, _dist, _speed);
	}

	@Override
	protected void initialize() {
		Robot.drive.resetEncoders();
		Robot.drive.resetGyro();
		i = 0;
	}

	@Override
	protected void execute() {
		i++;

		//double ang = Robot.drive.pidGet();

		double leftSpeed = speed;
		double rightSpeed = speed;

		//leftSpeed -= ang * kP;
		//rightSpeed += ang * kP;

		Robot.drive.setLeftSpeed(leftSpeed);
		Robot.drive.setRightSpeed(rightSpeed);
	}

	@Override
	protected boolean isFinished() {
		// Stop command if both encoders have gone the distance
		boolean isLeftFinished = Math.abs(Robot.drive.getLeftDistance() - dist) < 2;
		boolean isRightFinished = Math.abs(Robot.drive.getRightDistance() - dist) < 2;

		return isLeftFinished && isRightFinished;
	}

	@Override
	protected void end() {
		Robot.drive.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}

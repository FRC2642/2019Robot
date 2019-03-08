package frc.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 *
 */
public class MotionMagic extends Command {

	private double distance;
	private double margin;
	private double error;
	private int cv, accel;

	private final boolean isDiagnostic = true;

	public MotionMagic(double _distance, double _margin) {
		this(_distance, _margin, RobotMap.M_MAGIC_CV, RobotMap.M_MAGIC_ACCL);
	}

	public MotionMagic(double _distance, double _margin, int _cv, int _accel) {
		requires(Robot.drive);

		this.distance = _distance;
		this.margin = _margin;

		this.cv = _cv;
		this.accel = _accel;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		Robot.drive.resetEncoders();

		Robot.drive.setMotnCV(cv);
		Robot.drive.setMotnAccel(accel);

		Robot.drive.setkP(RobotMap.M_MAGIC_K_P);
		Robot.drive.setkI(RobotMap.M_MAGIC_K_I);
		Robot.drive.setkD(RobotMap.M_MAGIC_K_D);
		Robot.drive.setkF(RobotMap.M_MAGIC_K_F_L, RobotMap.M_MAGIC_K_F_R);

		System.out.print("Initializing Motion Magic");

		Robot.drive.setRightDistMotion(distance / RobotMap.DISTANCE_PER_PULSE);
		Robot.drive.setLeftDistMotion(distance / RobotMap.DISTANCE_PER_PULSE);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// double currentDistance = -Robot.drive.getLeftDistance() *
		// RobotMap.DriveMap.DISTANCE_PER_PULSE;
		double currentDistance = Robot.drive.getRightDistance();
		error = Math.abs(distance - currentDistance);

		if (isDiagnostic) {
			SmartDashboard.putNumber("MM Distance", currentDistance);
			SmartDashboard.putNumber("MM Error", error);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		boolean inSpeedMargin = Math.abs(Robot.drive.getRightSpeed()) < 1.0;
		boolean inDistMargin = Math.abs(error) < margin;

		// SmartDashboard.putNumber("Speed", Robot.drive.getRightSpeed());
		// SmartDashboard.putNumber("MM error = ", error);
		return ((inSpeedMargin) && (inDistMargin));
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
		System.out.println("Motn Magic Is Finished");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}

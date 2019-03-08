package frc.commands.drive;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.library.lib.math.Statistics;

/**
 *
 */
public class Characterize extends Command {

	public double speed;
	private ArrayList<Double> leftOutputs, rightOutputs;
	public static final double DEVIATION_THRESHOLD = 20;

	/**
	 * Characterize the drivetrain response at a given input speed
	 * 
	 * @param speed
	 *            The speed to test
	 */
	public Characterize(double _speed) {
		requires(Robot.drive);
	}

	protected void initialize() {
		Robot.drive.stop();

		// Create empty lists
		leftOutputs = new ArrayList<Double>(5);
		rightOutputs = new ArrayList<Double>(5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.setLeftSpeed(speed);
		Robot.drive.setRightSpeed(speed);

		// Remove oldest items in list
		leftOutputs.remove(0);
		rightOutputs.remove(0);

		// Add current speeds
		leftOutputs.add(Robot.drive.getLeftSpeed());
		rightOutputs.add(Robot.drive.getRightSpeed());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double leftDev = Statistics.standardDev(leftOutputs);
		double rightDev = Statistics.standardDev(rightOutputs);
		return leftDev < DEVIATION_THRESHOLD && rightDev < DEVIATION_THRESHOLD;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
		
		System.out.println("TRIAL: " + speed);
		System.out.println("==========");
		System.out.println("\tRaw Data: ");
		System.out.println("\t\tLEFT: " + leftOutputs);
		System.out.println("\t\tRIGHT: " + rightOutputs);

		System.out.println("\tLeft Stats: ");
		System.out.println("\t\tmean: " + Statistics.mean(leftOutputs));
		System.out.println("\t\tmedian: " + Statistics.median(leftOutputs));
		System.out.println("\t\tstd dev: " + Statistics.standardDev(leftOutputs));

		System.out.println("\tRight Stats: ");
		System.out.println("\t\tmean: " + Statistics.mean(rightOutputs));
		System.out.println("\t\tmedian: " + Statistics.median(rightOutputs));
		System.out.println("\t\tstd dev: " + Statistics.standardDev(rightOutputs));
	}

	protected void interrupted() {
		Robot.drive.stop();

		System.out.println("Process interrupted. Try again.");
	}
}

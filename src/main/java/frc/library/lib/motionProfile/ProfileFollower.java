package library.lib.motionProfile;

import library.lib.ticktock.Tickable;

/**
 * 
 * @author samcf_000
 *
 */

public class ProfileFollower implements Tickable {
	// Profile to be followed
	Profile profile;
	// Step of profile
	private int i = 0;
	// Source for position feedback
	public ProfileSource source;
	// Output for the motor power
	public ProfileOutput output;
	// Constants + Gains
	double kV, kA, kP;
	double endPosition;
	public volatile boolean onTarget = false;
	public volatile double error;

	private double margin;

	boolean isInverted;

	public ProfileFollower(Profile p, ProfileSource source, ProfileOutput output, DriveParameters params,
			boolean _isInverted) {
		this.profile = p;
		this.source = source;
		this.output = output;
		this.kV = params.kV;
		this.kA = params.kA;
		this.kP = params.kP;
		this.margin = p.margin;

		this.endPosition = p.get(p.length() - 1).position;

		this.isInverted = _isInverted;
	}

	public void restart() {
		this.i = 0;
		this.error = 1000;
	}

	@Override
	public void update() {
		// Make sure i is within bounds of profile
		if (i < 0) {
			i = 0;
		} else if (i >= profile.length()) {
			i = profile.length() - 1;
		}
		// Get position from the profile
		double position = profile.get(i).position;

		error = endPosition - source.getDistance();

		// Calculate the acceleration and velocity feedforward
		double v = kV * profile.get(i).speed;
		double a = kA * profile.get(i).acceleration;
		// Calculate the correction
		double correction = kP * (position - source.getDistance());
		System.out.println(kP);
		// Set the speed of the motor with correction
		if (isInverted) {
			output.setSpeed(-(v + correction));
		} else {
			output.setSpeed(a + v + correction);
		}
		// Increment our loop counter
		System.out.println(i);
		i++;
	}

	public boolean isFinished() {
		System.out.print(i);
		System.out.println(" " + (profile.length() - 1));
		System.out.println(Math.abs(error));
		return (Math.abs(error) < margin) && (i == profile.length());
	}
}

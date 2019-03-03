package library.lib.motionProfile;

/**
 * A ProfileParameters object contains all of the parameters necessary to build
 * a motion profile. You can pass an instance of ProfileParameters to the
 * profile constructor.
 * 
 *
 * @param d
 *            The maximum distance of the profile (ft)
 * @param v
 *            The maximum allowable maxVelocity (ft/s)
 * @param a
 *            The maximum allowable maxAccel (ft/s/s)
 * @param j
 *            The maximum allowable maxJerk (ft/s/s/s)
 */
public class ProfileParameters {
	public double distance, maxVelocity, maxAccel, maxJerk, margin, dt;

	public static final double DEFAULT_MARGIN = 1;
	public static final double DEFAULT_PERIOD = 1/50.0;

	public ProfileParameters(double d, double v, double a, double j, double _margin, double _dt) {
		distance = d;
		maxVelocity = v;
		maxAccel = a;
		maxJerk = j;
		margin = _margin;
		dt = _dt;
	}

	public ProfileParameters(double d, double v, double a, double j) {
		this(d, v, a, j, DEFAULT_MARGIN, DEFAULT_PERIOD);
	}

	public ProfileParameters(double d, double v, double a, double j, double _margin) {
		this(d, v, a, j, _margin, DEFAULT_PERIOD);
	}
}

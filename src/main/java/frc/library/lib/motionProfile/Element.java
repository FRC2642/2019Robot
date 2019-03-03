package library.lib.motionProfile;



public class Element {
	public double position;
	public double speed;
	public double acceleration;
	public double jerk;

	public Element(double position, double speed, double acceleration, double jerk) {
		this.position = position;
		this.speed = speed;
		this.acceleration = acceleration;
		this.jerk = jerk;
	}

	// You can initialize an element without parameters
	public Element() {
	}

	/**
	 * @return a comma-separated list of values
	 */
	@Override
	public String toString() {
		return position + "," + speed + "," + acceleration + "," + jerk;
	}
}
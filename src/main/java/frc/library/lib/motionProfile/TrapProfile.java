package library.lib.motionProfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TrapProfile {
	
	private double dist, max_vel, max_accel, dt;
	public double margin;
	
	private ArrayList<Element> profile;
	
	public TrapProfile(ProfileParameters _params) {
		this(_params.distance, _params.maxVelocity, _params.maxAccel, _params.dt, _params.margin);
	}
	
	/**
	 * Generate a trapezoidal motion profile
	 * 
	 * @param _dist The total distance to travel
	 * @param _max_vel The cruising velocity
	 * @param _max_accel The maximum acceleration
	 * @param _dt The delta-t between each element of the profile
	 */
	public TrapProfile(double _dist, double _max_vel, double _max_accel, double _dt, double _margin) {
		max_vel = _max_vel;
		max_accel = _max_accel;
		dist = _dist;
		dt = _dt;
		margin = _margin;
		
		profile = new ArrayList<Element>();
		profile.add(new Element(0,0,0,0));
		
		// Generate velocity ramp up
		for(double v = 0; v < max_vel; v += max_accel * dt) {
			Element e = new Element();
			
			e.acceleration = max_accel;
			e.speed = v;
			e.position = getLast().position + (getLast().speed * dt);

			profile.add(e);
		}
		
		// Cruise to halfway
		for(double p = getLast().position; p < (dist / 2); p += (max_vel * dt)) {
			Element e = new Element();
			
			e.acceleration = 0;
			e.speed = max_vel;
			e.position = p;
			
			profile.add(e);
		}
		
		// Mirror first half of profile
		for (int j = length()-1; j >= 0; j--) {
			Element f = get(j);
			Element e = new Element();
			e.position = dist - f.position;
			e.speed = f.speed;
			e.acceleration = -f.acceleration;

			profile.add(e);
		}
		System.out.println("Profile generated");
	}
	
	public Element get(int n) {
		return profile.get(n);
	}

	public Element getLast() {
		return get(this.length()-1);
	}

	private void add(Element e) {
		profile.add(e);
	}

	public int length() {
		return profile.size();
	}

	/**
	 * Automatically places the file in the user home on the roborio. Use this
	 * in your robot code.
	 * 
	 * @param filename
	 *            The name of the file to be saved, without an extension
	 */
	public void rioStore(String filename) {
		this.store("/home/lvuser/" + filename);
	}

	/**
	 * Stores a .csv file to a specified path. Use this for prototyping on your
	 * computer.
	 * 
	 * @param filename
	 *            the name of the file to be saved. Should include a directory
	 *            path.
	 */
	public void store(String filename) {
		String data = "";
		String path = filename + ".csv";

		data += "Time, Position, Velocity, Acceleration, Jerk";
		data += "\n";

		for (int i = 0; i < length(); i++) {
			data += (i * dt);
			data += ",";
			data += get(i).toString(); // Appends P, V, A, J on one line
			data += "\n"; // Creates a new line
		}

		try {
			File file = new File(path);
			FileWriter writer = new FileWriter(file, false);
			writer.write(data);
			writer.close();
			System.out.println("File creation succeeded");
		} catch (IOException exception) {
			System.out.println("File creation failed");
			System.out.println(exception.getMessage());
		}
	}
}

package library.lib.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Thrustmaster extends Joystick {

	public static final int TRIGGER = 1;
	public static final int BUTTON_MIDDLE = 2;
	public static final int BUTTON_LEFT = 3;
	public static final int BUTTON_RIGHT = 4;

	public static class Axes {
		public static final int X = 0;
		public static final int Y = 1;
		public static final int Z = 2;
		public static final int THROTTLE = 3;
	}

	public JoystickButton trigger, middle, left, right;

	public double deadzone = 0;

	public Thrustmaster(int port) {
		this(port, 0);
	}

	public Thrustmaster(int port, double _deadzone) {
		super(port);
		this.deadzone = _deadzone;

		trigger = new JoystickButton(this, TRIGGER);
		middle = new JoystickButton(this, BUTTON_MIDDLE);
		left = new JoystickButton(this, BUTTON_LEFT);
		right = new JoystickButton(this, BUTTON_RIGHT);
	}

	public double getRawX() {
		return super.getRawAxis(Axes.X);
	}

	public double x() {
		double raw = this.getRawX();

		if (Math.abs(raw) < deadzone) {
			return 0;
		}
		return raw;
	}

	public double getRawY() {
		return -super.getRawAxis(Axes.Y);
	}

	public double y() {
		double raw = this.getRawY();

		if (Math.abs(raw) < deadzone) {
			return 0;
		}
		return raw;
	}

	public double z() {
		return super.getRawAxis(Axes.Z);
	}
}

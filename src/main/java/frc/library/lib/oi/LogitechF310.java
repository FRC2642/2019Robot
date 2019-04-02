package frc.library.lib.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechF310 extends Joystick {

	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LB = 5;
	public static final int RB = 6;
	public static final int BACK = 7;
	public static final int START = 8;
	public static final int LEFT_PRESS = 9;
	public static final int RIGHT_PRESS = 10;

	public class Axes {
		public static final int LEFT_X = 0;
		public static final int LEFT_Y = 1;
		public static final int LT = 2;
		public static final int RT = 3;
		public static final int RIGHT_X = 4;
		public static final int RIGHT_Y = 5;
	}

	public final JoystickButton a, b, x, y, lb, rb, back, start, leftPress, rightPress;

	public LogitechF310(int port) {
		super(port);

		// Create buttons
		a = new JoystickButton(this, A);
		b = new JoystickButton(this, B);
		x = new JoystickButton(this, X);
		y = new JoystickButton(this, Y);

		lb = new JoystickButton(this, LB);
		rb = new JoystickButton(this, RB);

		back = new JoystickButton(this, BACK);
		start = new JoystickButton(this, START);

		leftPress = new JoystickButton(this, LEFT_PRESS);
		rightPress = new JoystickButton(this, RIGHT_PRESS);
	}

	public double getLeftX() {
		return super.getRawAxis(Axes.LEFT_X);
	}

	public double getLeftY() {
		return super.getRawAxis(Axes.LEFT_Y);
	}

	public double getRightX() {
		return super.getRawAxis(Axes.RIGHT_X);
	}

	public double getRightY() {
		return super.getRawAxis(Axes.RIGHT_Y);
	}

	public double getLeftTrigger() {
		return super.getRawAxis(Axes.LT);
	}

	public double getRightTrigger() {
		return super.getRawAxis(Axes.RT);
	}
}

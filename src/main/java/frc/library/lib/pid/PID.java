package frc.library.lib.pid;

import frc.library.lib.ticktock.Tickable;
import frc.library.lib.ticktock.Ticker;

public class PID implements Tickable {
	private volatile PIDParameters gains;
	private PIDSource source;
	private PIDOutput output;
	private volatile double setpoint;
	private volatile double error;
	private double errSum;
	private double delta;
	private double lastError;
	private Ticker ticker;

	private double total;

	/**
	 * A tickable that handles PID control of a system
	 * 
	 * @author Sam
	 * @param _source
	 *            The object from which to read the position of the system
	 * @param _output
	 *            The object to set speed with PID control
	 * @param _gains
	 *            The PID gains to configure the PID controller
	 */
	public PID(PIDSource _source, PIDOutput _output, PIDParameters _gains) {
		this.setGains(_gains);
		this.source = _source;
		this.output = _output;
		this.ticker = new Ticker(this, gains.interval);
	}

	public synchronized void setGains(PIDParameters _gains) {
		double kP = _gains.kP;
		double kI = _gains.kI * _gains.interval;
		double kD = _gains.kD / _gains.interval;
		this.gains = new PIDParameters(kP, kI, kD, _gains.interval);
	}
	
	public void enable() {
		ticker.start();
	}
	
	public void disable() {
		ticker.stop();
	}

	public void setSetpoint(double _setpoint) {
		this.setpoint = _setpoint;
	}

	public double getSetpoint() {
		return setpoint;
	}
	
	public double getError() {
		return error;
	}

	@Override
	public void update() {
		//double input = this.source.getPos();

		if (Math.abs(error) < 0.2) {
			errSum = 0;
		}

		// Compute working error vars
		error = setpoint - source.pidGet();
		errSum += error;
		delta = error - lastError;

		// Compute PID output
		total = (gains.kP * error) + (gains.kI * errSum) - (gains.kD * delta);

		// Set output to the computed value
		output.pidSet(total);

		// Get ready for next update
		lastError = error;
	}
}

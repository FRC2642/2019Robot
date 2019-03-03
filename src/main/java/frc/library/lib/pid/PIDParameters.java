package library.lib.pid;

public class PIDParameters {
	public double kP, kI, kD;
	public double interval;

	public PIDParameters(double _kP, double _kI, double _kD, double _interval) {
		this.kP = _kP;
		this.kI = _kI;
		this.kD = _kD;
		this.interval = _interval;
	}
}

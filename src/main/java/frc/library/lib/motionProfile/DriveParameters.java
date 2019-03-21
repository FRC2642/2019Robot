package frc.library.lib.motionProfile;
/*
 * given lib, not entirely sure how it works
 */
public class DriveParameters {
	public double kP, kV, kV_l, kV_r, kA, kA_l, kA_r;

	public DriveParameters(double _kV_l, double _kV_r, double _kA_l, double _kA_r, double _kP) {
		this.kV_l = _kV_l;
		this.kV_r = _kV_r;
		this.kA_l = _kA_l;
		this.kA_r = _kA_r;
		this.kP = _kP;
	}
	
	public DriveParameters(double _kV, double _kA, double _kP) {
		this(_kV, _kV, _kA, _kA, _kP);
		this.kV = _kV;
		this.kA = _kA;
	}
	
	public DriveParameters(double _kV_l, double _kV_r, double _kA, double _kP) {
		this(_kV_l, _kV_r, _kA, _kA, _kP);
		this.kA = _kA;
	}
}

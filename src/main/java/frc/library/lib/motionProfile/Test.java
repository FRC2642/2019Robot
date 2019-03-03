package library.lib.motionProfile;

public class Test {

	public static void main(String[] args) {
		ProfileParameters params = new ProfileParameters(256, 100, 100, 0, 3);
		
		TrapProfile p = new TrapProfile(params);
		
		p.store("test");
	}
}

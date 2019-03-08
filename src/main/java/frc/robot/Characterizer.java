package frc.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Characterizer {

	private static PrintWriter writer;
	private static StringBuilder builder;

	private String filename = "char.csv";

	public Characterizer(String _filename) {
		this.filename = _filename;
	}

	public Characterizer() {
	}

	public void init() throws FileNotFoundException {
		writer = new PrintWriter(new File(filename));
		builder = new StringBuilder();

		// Write header line
		builder.append("Left input");
		builder.append(',');
		builder.append("Left output");
		builder.append(',');
		builder.append("Right input");
		builder.append(',');
		builder.append("Right output");
		builder.append('\n');
	}

	public void update() {
		builder.append(OI.xbox.getY());
		builder.append(',');
		builder.append(Robot.drive.getLeftSpeed());
		builder.append(',');
		builder.append(OI.xbox.getY());
		builder.append(',');
		builder.append(Robot.drive.getRightSpeed());
		builder.append('\n');
	}

	public void finish() {
		writer.write(builder.toString());
		writer.close();
		System.out.println("Wrote characterization file");
	}
}

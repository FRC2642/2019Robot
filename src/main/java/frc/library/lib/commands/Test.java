package library.lib.commands;


import edu.wpi.first.wpilibj.command.Command;

/**runs test mode on the drivers station
 *
 */
public class Test extends Command {
	private String name;

	public Test(String _name) {
		this.name = _name;
	}

	@Override
	protected void initialize() {
		System.out.println("Test (init): " + name);
	}

	@Override
	protected void execute() {
		System.out.println("Test (exec): " + name);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		System.out.println("Test (end): " + name);
	}

	@Override
	protected void interrupted() {
		System.out.println("Test (interrupt): " + name);
	}
}

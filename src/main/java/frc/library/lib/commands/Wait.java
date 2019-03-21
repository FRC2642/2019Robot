package frc.library.lib.commands;

import edu.wpi.first.wpilibj.command.Command;

/**basic wait for seconds command
 *
 */
public class Wait extends Command {
	double waitTime;
	int i = 0;
	double dt = (1 / 50.0);

	public Wait(double seconds) {
		this.waitTime = seconds;
	}
	
	public Wait(double seconds, double _dt) {
		this(seconds);
		this.dt = _dt;
	}

	@Override
	protected void initialize() {
		i = 0;
	}

	@Override
	protected void execute() {
		i++;
	}

	@Override
	protected boolean isFinished() {
		return (i / 50.0) > waitTime;
	}

	@Override
	protected void end() {
	}
}

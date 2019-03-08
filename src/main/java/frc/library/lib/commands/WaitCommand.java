package frc.library.lib.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**delay wait
 * somehow different
 * im not questioning the library
 *
 */
public class WaitCommand extends CommandGroup {

	/**
	 * Start a command on a delay
	 * @param delay The delay before the command starts, in seconds
	 * @param command The command to start
	 * @param timeout The timeout for the command
	 */
	public WaitCommand(double delay, Command command, double timeout) {
		addSequential(new Wait(delay));
		addSequential(command, timeout);
	}

	/**
	 * Start a command on a delay
	 * @param delay The delay before the command starts, in seconds
	 * @param command The command to start
	 */
	public WaitCommand(double delay, Command command) {
		addSequential(new Wait(delay));
		addSequential(command);
	}
}

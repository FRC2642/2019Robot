package frc.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.commands.drive.StraightDrive;


public class Cross extends CommandGroup {
	/**
	 * Cross the auto line
	 */
	public Cross() {
		addSequential(new StraightDrive(-.5), 3);
		
		//addSequential(new FollowProfile(Robot.SQUARE_TEST, RobotMap.DriveMap.DRIVE_PARAMS, true));
	}

	@Override
	public String toString() {
		return "Cross";
	}
}
package frc.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 *
 */
public class DriveWithJoysticks extends Command {

	public DriveWithJoysticks() {
		requires(Robot.drive);
	}

	protected void initialize() {
	}

	protected void execute() {

		Robot.drive.gyroCalibration();

			//High Speed 
			//SICKO MODE
			if(isRightTriggerPulled()) {
				Robot.drive.arcadeDrive(OI.xbox.getRawAxis(1), OI.xbox.getRawAxis(0));
					
				//Medium Speed Drive
				//sicko mode
			} else if(isLeftTriggerPulled()) {
				Robot.drive.arcadeDrive(OI.xbox.getRawAxis(1) * .8, OI.xbox.getRawAxis(0) * .8);
				//Low Drive
				//not so sicko mode
			} else {
				Robot.drive.arcadeDrive(OI.xbox.getRawAxis(1) * .6, OI.xbox.getRawAxis(0) * .6);
		}
	
	
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		end();
	}
	public boolean isRightTriggerPulled() {
    	if(OI.xbox.getRawAxis(3) > .5) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public boolean isLeftTriggerPulled() {
    	if(OI.xbox.getRawAxis(2) > .5) {
    	return true;
    } else {
    	return false;	
    	}
}
}

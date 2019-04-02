/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto.vision;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class EnableVisionTracking extends InstantCommand {
  /**
   * Add your docs here.
   */
 
	private boolean state;

	//Sets the current vision mode for the boilerCamera
    public EnableVisionTracking(boolean state) {
        super();
        this.state = state;
    }

    // Called once when the command executes
    protected void initialize() {
    //	Robot.EnableVisionTracking(state);
    }


}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.commands.drive.DriveAtTarget;
import frc.commands.mast.MoveMastToCameraHeight;

public class DriveAtRRTape extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DriveAtRRTape() {
  
    addSequential(new MoveMastToCameraHeight());
    addSequential(new EnableVisionTracking(true));
    addSequential(new DriveAtTarget());

  }
}

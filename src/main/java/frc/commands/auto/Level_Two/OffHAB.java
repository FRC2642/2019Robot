/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto.Level_Two;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.commands.auto.Turn;
import frc.commands.drive.StraightDrive;
import frc.robot.RobotMap;
public class OffHAB extends CommandGroup {
  /**
   * Add your docs here.
   */ 
  public OffHAB() {

    addSequential(new StraightDrive(.5), 2);
    addSequential(new StraightDrive(.80), 2.563);
    addSequential(new Turn(180, 1, RobotMap.TURN_PARAMS_180));

  }

}

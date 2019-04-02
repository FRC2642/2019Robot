/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.commands.drive.StraightDrive;

public class Cross extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Cross() {

      addSequential(new StraightDrive(-.5), 1.54);
      addSequential(new StraightDrive(-.9), 4);
  
      
  
      //addSequential(new FollowProfile(Robot.SQUARE_TEST, RobotMap.DriveMap.DRIVE_PARAMS, true));
  
    }
  
  
  
    @Override
  
    public String toString() {
  
      return "Cross";
  
    }
  }

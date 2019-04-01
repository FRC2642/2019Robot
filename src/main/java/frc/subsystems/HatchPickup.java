/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.intake.HatchUpCommand;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchPickup extends Subsystem {
    // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
public Solenoid hatchCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.HatchCylinderPort);

public void hatchUp() {
  hatchCylinder.set(true);
}


public void hatchDown() {
  hatchCylinder.set(false);
}

public void set(){
  if(OI.aux.getRawButton(4)){
    hatchCylinder.set(false);
  } 
  else if(OI.aux.getRawButton(3)){
    hatchCylinder.set(true);
  }
}



@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new HatchUpCommand());
  }
}

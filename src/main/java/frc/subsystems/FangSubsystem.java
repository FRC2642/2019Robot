/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.fangs.newFangsCommand;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class FangSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  public Solenoid fangCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.fangCylinderPort);

public void fangsIn() {
fangCylinder.set(true);
}


public void fangsOut() {
 fangCylinder.set(false);
}

public void set(){
  if(OI.aux.getRawButton(3)){
    fangCylinder.set(true);
  } else{
    fangCylinder.set(false);
  }
}
//public boolean FangStatus(){
 /* if(fangsOut()){
    return false;
  }
  else{
    return true;
  }*/

@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new newFangsCommand());
  }
}

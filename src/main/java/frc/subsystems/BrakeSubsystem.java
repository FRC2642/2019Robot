/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.brake.BrakeCommand;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BrakeSubsystem extends Subsystem {
  public Solenoid brakeCylinder = new Solenoid(RobotMap.ID_PCM,RobotMap.brakeCylinderPort);

  public void brakeOn(){
    brakeCylinder.set(false);
  }

  public void brakeOff(){
    brakeCylinder.set(true);
  }

  public boolean getBrakeCylinderState() {
    return brakeCylinder.get();
  }

  public boolean isMastMoving(){
    if(OI.aux.getRawAxis(5) > .2 || OI.aux.getRawAxis(5) < -.2){
      return true;
    } else{
      return false;
    }
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new BrakeCommand());
  }



}

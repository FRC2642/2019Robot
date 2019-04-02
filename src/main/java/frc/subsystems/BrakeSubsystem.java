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
import frc.robot.RobotMap;

/**
 * This system activates the braking system on the mast.
 * This keeps the mast from drifting down when there is no driver input.
 */
public class BrakeSubsystem extends Subsystem {

  public Solenoid brakeCylinder = new Solenoid(RobotMap.ID_PCM,RobotMap.brakeCylinderPort);

      public BrakeSubsystem(){
      }

  public void brakeOn(){
    brakeCylinder.set(true);
  }

  public void brakeOff(){
    brakeCylinder.set(false);
  }

  public boolean getBrakeCylinderState() {
    return brakeCylinder.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new BrakeCommand());
  }
}

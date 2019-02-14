/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class FangSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  public DoubleSolenoid fangCylinder = new DoubleSolenoid(RobotMap.fangCylinderPort1, RobotMap.fangCylinderPort2);

public void fangsOut() {
fangCylinder.set(Value.kForward);
}


public void fangsIn() {
  fangCylinder.set(Value.kReverse);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

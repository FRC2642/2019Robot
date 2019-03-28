/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LightRingSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark lightTestSpark = new Spark(0);
 public static VictorSPX lightController = new VictorSPX(RobotMap.ID_LIGHT);

public void testOn(){
  lightTestSpark.setSpeed(1);
}

public void testOff(){
  lightTestSpark.setSpeed(0);
}

public static void lightOn(){
  lightController.set(ControlMode.PercentOutput, 1);
}
public static void lightOff(){
  lightController.set(ControlMode.PercentOutput, 0);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

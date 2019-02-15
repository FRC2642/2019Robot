/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class LightSensorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
DigitalInput lightSensor = new DigitalInput(RobotMap.lightSensorPort);
//sensesLight and sensesDarkness are relative as there will not be pure light or darkness, rather varying levels of light.
public void sensesLight() {

}

public void sensesDarkness() {
  
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
    public static XboxController aux = new XboxController(RobotMap.xboxControllerPort);

 public Button XboxA = new JoystickButton(xbox, 1);
 public Button XboxB = new JoystickButton(xbox, 2);
 Button XboxX = new JoystickButton(xbox, 3);
public OI() {
    xboxB.whenPressed(new SuccOn());
    xboxX.whenPressed(new SuccOff());
}

}

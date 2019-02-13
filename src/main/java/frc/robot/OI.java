/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.commands.mast.MoveMastToBottomCommand;
import frc.commands.mast.MoveMastToMiddleCommand;
import frc.commands.mast.MoveMastToTopCommand;
import frc.commands.vacuum.SuccOffCommand;
import frc.commands.vacuum.SuccOnCommand;

public class OI {
    public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
    public static XboxController aux = new XboxController(RobotMap.auxXboxControllerPort);

 Button xboxA = new JoystickButton(xbox, 1);
 Button xboxB = new JoystickButton(xbox, 2);
 Button xboxX = new JoystickButton(xbox, 3);
 Button xboxLeftAnalog = new JoystickButton(xbox, 9);

 Button auxXboxA = new JoystickButton(aux, 1);
 Button auxXboxB = new JoystickButton(aux, 2);
 Button auxXboxY = new JoystickButton(aux, 4);
 

 public OI() {
    xboxB.whenPressed(new SuccOnCommand());
    xboxX.whenPressed(new SuccOffCommand());

    auxXboxA.whenPressed(new MoveMastToBottomCommand());
    auxXboxB.whenPressed(new MoveMastToMiddleCommand());
    auxXboxY.whenPressed(new MoveMastToTopCommand());
}
}
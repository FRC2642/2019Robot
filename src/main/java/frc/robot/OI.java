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
import frc.commands.fangs.FangsDeploy;
import frc.commands.intake.PressCupsCommand;
import frc.commands.thrust.JackDownCommand;
import frc.commands.thrust.JackUpCommand;
import frc.commands.vacuum.SuccOffCommand;
import frc.commands.vacuum.SuccOnCommand;

public class OI {
    public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
    public static XboxController aux = new XboxController(RobotMap.auxXboxControllerPort);

 Button xboxA = new JoystickButton(xbox, 1);
 Button xboxX = new JoystickButton(xbox, 3);
 Button xboxY = new JoystickButton(xbox, 4);
 Button xboxLeftBumper = new JoystickButton(xbox, 5);
 Button xboxRightBumper = new JoystickButton(xbox, 6);
 Button xboxSelect = new JoystickButton(xbox, 7);
 //Button xboxLeftStick = new JoystickButton(xbox, 9);

 Button auxXboxA = new JoystickButton(aux, 1);
 Button auxXboxB = new JoystickButton(aux, 2);
 Button auxXboxY = new JoystickButton(aux, 4);
 Button auxXboxRightBumper = new JoystickButton(aux, 6);

 public OI() {
    xboxX.whenPressed(new SuccOnCommand());
    xboxY.whenPressed(new SuccOffCommand());
    xboxA.whenPressed(new PressCupsCommand());
    xboxLeftBumper.whenPressed(new JackDownCommand());
    xboxRightBumper.whenPressed(new JackUpCommand());

    
    auxXboxRightBumper.whenPressed(new FangsDeploy());
    /*auxXboxA.whenPressed(new MoveMastToBottomCommand());
    auxXboxB.whenPressed(new MoveMastToMiddleCommand());
    auxXboxY.whenPressed(new MoveMastToTopCommand());
    */

    
}
}
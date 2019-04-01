/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.commands.climb.StopClimbCommand;
import frc.commands.climb.ClimbCommand;
import frc.commands.intake.HatchDownCommand;
import frc.commands.intake.HatchUpCommand;
//import frc.commands.mast.MastPistonDown;
//import frc.commands.mast.MastPistonUp;
//import frc.commands.mast.MoveMastToBottomCommand;
import frc.commands.mast.MoveMastToMiddleCommand;
import frc.commands.mast.MoveMastToTopCommand;
import frc.commands.thrust.JackDownCommand;
import frc.commands.thrust.JackOffCommand;
import frc.commands.thrust.JackUpCommand;
import frc.commands.util.DisableLimitsCommand;

public class OI {
    public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
    public static XboxController aux = new XboxController(RobotMap.auxXboxControllerPort);
    public static Joystick autoDial = new Joystick(RobotMap.autoSelectorJoystickPort);

    Button xboxA = new JoystickButton(xbox, 1);
    Button xboxB = new JoystickButton(xbox, 2);
    Button xboxX = new JoystickButton(xbox, 3);
    Button xboxY = new JoystickButton(xbox, 4);
 Button xboxLeftBumper = new JoystickButton(xbox, 5);
 Button xboxRightBumper = new JoystickButton(xbox, 6);
 Button xboxSelect = new JoystickButton(xbox, 7);
 Button xboxStart = new JoystickButton(xbox, 8);
 //Button xboxLeftStick = new JoystickButton(xbox, 9);

 Button auxXboxA = new JoystickButton(aux, 1);
 Button auxXboxB = new JoystickButton(aux, 2);
 Button auxXboxY = new JoystickButton(aux, 4);
 Button auxXboxX = new JoystickButton(aux, 3);
 Button auxXboxRightBumper = new JoystickButton(aux, 6);
 Button auxXboxLeftBumper = new JoystickButton(aux, 5);
 Button auxXboxSelect = new JoystickButton(xbox, 7);
 Button auxXboxStart = new JoystickButton(xbox, 8);




 public static Button dial1 = new JoystickButton(autoDial, 1);
 public static Button dial2 = new JoystickButton(autoDial, 2);
 public static Button dial3 = new JoystickButton(autoDial, 3);
 public static Button dial4 = new JoystickButton(autoDial, 4);
 public static Button dial5 = new JoystickButton(autoDial, 5);
 public static Button dial6 = new JoystickButton(autoDial, 6);
 public static Button dial7 = new JoystickButton(autoDial, 7);
 public static Button dial8 = new JoystickButton(autoDial, 8);
 public static Button dial9 = new JoystickButton(autoDial, 9);
 public static Button dial10 = new JoystickButton(autoDial, 10);
 public static Button dial11 = new JoystickButton(autoDial, 11);
 public static Button dial12 = new JoystickButton(autoDial, 12);
 public static Button dial13 = new JoystickButton(autoDial, 13);


 public OI() {
    xboxLeftBumper.whileHeld(new JackDownCommand());
    xboxLeftBumper.whenReleased(new JackOffCommand()); 
    xboxRightBumper.whileHeld(new JackUpCommand());
    xboxRightBumper.whenReleased(new JackOffCommand()); 
    xboxA.whileHeld(new ClimbCommand());
    xboxA.whenReleased(new StopClimbCommand());
    //axis 1 is drive
    //xboxB is used for roller
    //sicko mode on axis 2/3 
    //roller on 7 (xbox select)
    

    auxXboxSelect.whenPressed(new DisableLimitsCommand());
   // auxXboxA.whenPressed(new DriveAtRRTape());
   // auxXboxB.whenPressed(new MoveMastToMiddleCommand());
   // auxXboxY.whenPressed(new MoveMastToTopCommand());
    //left trigger intake in     \ axis 2&3
    //right trigger intake out   /
    //move lift on axis 5
    //3rd stage piston on bumbers 
    //hatch buttons on 3 and 4
    
}
}
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
import frc.commands.climb.JackDownCommand;
import frc.commands.climb.JackOffCommand;
import frc.commands.climb.JackUpCommand;
import frc.commands.climb.RollerOffCommand;
import frc.commands.climb.RollerOnCommand;


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
    /* 
    xbox (main drive) controls:

    left stick (axis 0 + 1) = regular drive
        left trigger (axis 2) = slow drive (for precision)
        right trigger (axis 3) = fast drive (for going sicko mode)

    left bumper = jack (rear climb) down  (push and hold)
    right bumper = jack (rear climb) up   (push and hold)

    right stick (axis 4 +5) = front jack for climb
    d-pad up and down = back jack for climb

    select = run rollers at bottom of jack  (push and hold)
    */
    xboxLeftBumper.whileHeld(new JackDownCommand());
    xboxLeftBumper.whenReleased(new JackOffCommand()); 
    xboxRightBumper.whileHeld(new JackUpCommand());
    xboxRightBumper.whenReleased(new JackOffCommand()); 
    xboxSelect.whileHeld(new RollerOnCommand());
    xboxSelect.whenReleased(new RollerOffCommand());
    //xboxA.whileHeld(new DriveAtRRTape());

    /*
    aux (auxillery drive) controls

    right stick (axis 4 + 5) = move mast up/down regular speed
    left stick (axis 0 + 1) = move mast up/down slow speed (for precision)
        //brake activates when both sticks are in neutral position

    right bumper = mast piston up
    left bumper = mast piston down

    left trigger (axis 2) = intake ball in 
    right trigger (axis 3) = shoot ball out 

    x = hatch finger up (locked position)
    y = hatch finger down (pickup position)
   */

  }
}
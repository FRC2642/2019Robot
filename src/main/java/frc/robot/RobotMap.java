/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.library.lib.motionProfile.DriveParameters;
import frc.library.lib.pid.PIDParameters;

/**
 * Add your docs here.
 */
public class RobotMap {
    //IDs for drive motors
    public static final int ID_RIGHT_FRONT_DRIVE = 1;
    public static final int ID_RIGHT_REAR_DRIVE = 16;
    public static final int ID_LEFT_FRONT_DRIVE = 2;
    public static final int ID_LEFT_REAR_DRIVE = 3;
    //ID for wrist motor
    public static final int ID_WRIST = 4;
    //ID for intake motors
    public static final int ID_FRONT_MASTER = 8;
    public static final int ID_SHOOTER_MASTER = 9;
    //ID for roller lifting motor 
    public static final int ID_ROLLER = 10;
    //ID for vacuum motor
    public static final int ID_VACUUM = 11;
    //ID for jack motor
    public static final int ID_JACK = 12;
    //IDs for mast motors 
    public static final int ID_MAST_SLAVE = 14;
    public static final int ID_MAST_MASTER = 15;
    //ID for PCM 
    public static final int ID_PCM = 17;
    //PigeonIMU ID
    public static int ID_PIGEON = 20;
    
    //Image resoulution constants
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
    
    //ID for USB Camera
    public static final int sandstormCameraPort = 1;
    
    //port for light sensors
    public static int lightSensorPort = 1; 
    //mast pot port
    public static int mastPotPort = 0;
    //wrist pot port
    public static int wristPotPort = 5;
  
    //port for suction cup piston
    public static int cupsCylinderPort = 6;
    //ports for wrist piston
    public static int wristCylinderPort = 7;
    //port for brake cylinder
    public static int brakeCylinderPort = 0;
    //ports for fang cylinder
    public static int fangCylinderPort = 2;
    //ports for mast cylinder
    public static int mastCylinderPort = 1;
    

    //xbox controller ports
    public static int xboxControllerPort = 0;
    public static int auxXboxControllerPort = 1;
    //Auto Selector Joystick port
    public static int autoSelectorJoystickPort = 2;
    
    //drive motor limit settings
    public static final boolean IS_CURRENT_LIMIT = false;
    public static final int PEAK_CURRENT = 45;
    public static final int CONTINUOUS_CURRENT = 30;
    public static final int PEAK_CURRENT_DURATION = 200;
    //drive motor voltage settings
    public static final boolean IS_VOLTAGE_COMP = false;
    public static final double VOLTAGE_SATURATION = 12.5;

    //# of pulses in 1 rotation
    public static final int PULSES_PER_ROTATION = 4096;
    //length of chain used in one rotation (mast)
    public static float mastChainLength = (float) 5.5;

    //mast height limits
    public static double maxMastHeight = .644;
    public static double minMastHeight = .19;
    
    //DIO Ports for Limit Switches
    public static final int mastUpperLimitSwitch = 2;
    public static final int mastLowerLimitSwitch = 4;
    public static final int jackLimitSwitch = 0;
    public static final int intakeLimitSwitch = 6;

    //panic button values
    public static boolean isMastLimitEnabled = true;

    //Drive params                                                           
    public static final DriveParameters DRIVE_PARAMS  = new DriveParameters(.0058, .0064, .003, -.8);

    //PID params                                                             P    I       D    interval
    public static final PIDParameters TAPE_DRIVE_PARAMS = new PIDParameters(.01 , .0  ,  .0,   1 / 50.0);
    public static final PIDParameters TURN_PARAMS_45    = new PIDParameters(.06 , .0  , -.003, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_90    = new PIDParameters(.005, .002, -.002, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_180   = new PIDParameters(.06 , .003, -.001, 1 / 100.0);
    }


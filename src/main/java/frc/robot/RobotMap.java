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
    //ID for lightring motor controller
    public static final int ID_LIGHT = 4;
    //ID for intake motors
    public static final int ID_FRONT_MASTER = 8;
    public static final int ID_SHOOTER_MASTER = 9;
    //ID for roller lifting motor 
    public static final int ID_ROLLER = 10;
    //ID for winch motor
    public static final int ID_WINCH = 11;
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
 
    //wrist pot port
    public static int wristPotPort = 5;
  
    //port for brake cylinder
    public static int brakeCylinderPort = 0;
    
    //ports for mast cylinder
    public static int mastCylinderPort = 1;

    public static int HatchCylinderPort = 2;

    public static int climbCylinderPort = 4;
    

    //xbox controller ports
    public static int xboxControllerPort = 1;
    public static int auxXboxControllerPort = 2;
    //Auto Selector Joystick port
    public static int autoSelectorJoystickPort = 0;
    
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
    public static double maxMastHeight = 1.0;
    //.65 ;
    public static double minMastHeight = 0.0;
    //.136;
    
    //DIO Ports for Limit Switches
    public static final int mastUpperLimitSwitch = 2;
    public static final int mastLowerLimitSwitch = 4;
    public static final int jackLimitSwitch = 0;
    public static final int intakeLimitSwitch = 6;

    //panic button values
    public static boolean isMastLimitEnabled = true;

    public static int MastEncoderA = 8;
    public static int MastEncoderB = 9;
    //Drive params                                                           
    public static final DriveParameters DRIVE_PARAMS  = new DriveParameters(.0058, .0064, .003, -.8);

    //PID params                                                             P    I       D    interval
    public static final PIDParameters TAPE_DRIVE_PARAMS = new PIDParameters(.01 , .0  ,  .0,   1 / 50.0);
    public static final PIDParameters TURN_PARAMS_45    = new PIDParameters(.06 , .0  , -.003, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_90    = new PIDParameters(.005, .002, -.002, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_180   = new PIDParameters(.06 , .003, -.001, 1 / 100.0);

    //vision
    public static final boolean visionEnabled = true;

    public static double driveForwardOffset = 0.25;
	public static double driveTurnOffset = 0.25;
	public static double driveGTurnOffset = 2.0;
    public static double driveCorrection = -0.2;
    
    public static int cam = 0;
    }


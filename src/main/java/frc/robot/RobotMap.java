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
 * This holds all static port numbers, CAN IDs, static values, etc.
 */
public class RobotMap {

    //CAN IDs

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
    //ID for jack motor
    public static final int ID_JACK = 12;
    //ID for climb motor
    public static final int ID_FRONT_CLIMB = 13;
    //IDs for mast motors 
    public static final int ID_MAST_SLAVE = 14;
    public static final int ID_MAST_MASTER = 15;
    //ID for PCM 
    public static final int ID_PCM = 17;
    //PigeonIMU ID
    public static int ID_PIGEON = 20;
    
    //solenoid ports

    //port for brake cylinder
    public static int brakeCylinderPort = 0;
    //port for mast cylinder
    public static int mastCylinderPort = 1;
    //port for hatch finger cylinder
    public static int hatchCylinderPort = 2;

    //DIO ports (for limit switches)

    //port for jack (rear climb) limit switch
    public static final int jackLimitSwitchPort = 0;
    //ports for upper and lower mast limit switches
    public static final int mastUpperLimitSwitchPort = 2;
    public static final int mastLowerLimitSwitchPort = 4;
    //port for ball intake limit switch
    public static final int intakeLimitSwitchPort = 6;
    //ports (both channels) for encoder on mast
    public static int mastEncoderA = 8;
    public static int mastEncoderB = 9;

    //driverstation USBs - controllers + autoselecter

    //port for estop autoselector
    public static int autoSelectorJoystickPort = 0;
    //ports for xbox controllers
    public static int xboxControllerPort = 1;
    public static int auxXboxControllerPort = 2;
 
    //USB port and constants for camera

    //port for USB camera
    public static final int sandstormCameraPort = 1;
    //camera feed height and width
	public static final int IMG_WIDTH = 320;
    public static final int IMG_HEIGHT = 240;
    //retroreflective vision mode 
    public static final boolean visionEnabled = true;
    
    //settings for Talons 

    //limit settings
    public static final boolean IS_CURRENT_LIMIT = false;
    public static final int PEAK_CURRENT = 45;
    public static final int CONTINUOUS_CURRENT = 30;
    public static final int PEAK_CURRENT_DURATION = 200;
    //voltage settings
    public static final boolean IS_VOLTAGE_COMP = false;
    public static final double VOLTAGE_SATURATION = 12.5;

    //PID profiles and settings

    //Drive params                                                           
    public static final DriveParameters DRIVE_PARAMS  = new DriveParameters(.0058, .0064, .003, -.8);
    //PID params                                                             P    I       D    interval
    public static final PIDParameters TURN_PARAMS_45    = new PIDParameters(.06 , .0  , -.003, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_90    = new PIDParameters(.005, .002, -.002, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_180   = new PIDParameters(.06 , .003, -.001, 1 / 100.0);
    //pid for climb balancing
    public static final PIDParameters CLIMB_PARAMS = new PIDParameters(.01, 0.0, 0.0, 1 / 100);
    //pid for mast 
    public static final PIDParameters MAST_PARAMS = new PIDParameters(.01, 0.0, 0.0, 1 / 100);
    //gyro offset values
    public static double driveForwardOffset = 0.25;
	public static double driveTurnOffset = 0.25;
    public static double driveGTurnOffset = 2.0;
    //motor speed correction value
    public static double driveCorrection = -0.2; 
    //mast height for hatch 
    public static double mastHatchHeight = 1.0;
    }


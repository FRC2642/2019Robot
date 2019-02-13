/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class RobotMap {
    //IDs for drive motors
    public static final int ID_RIGHT_FRONT_DRIVE = 1;
    public static final int ID_RIGHT_REAR_DRIVE = 16;
    public static final int ID_LEFT_FRONT_DRIVE = 2;
    public static final int ID_LEFT_REAR_DRIVE = 3;
     //ID for vacuum motor
    public static final int ID_VACUUM = 4;
    //ID for intake motors
    public static final int ID_INTAKE_MASTER = 8;
    public static final int ID_INTAKE_SLAVE = 9;
    //ID for roller lifting motor 
    public static final int ID_ROLLER = 10;
    //ID for jack motor
    public static final int ID_JACK = 12;
    //ID for wrist motor
    public static final int ID_WRIST = 13;
    //IDs for mast motors 
    public static final int ID_MAST_SLAVE = 14;
    public static final int ID_MAST_MASTER = 15;
    //ID for PCM 
    public static final int ID_PCM = 17;

    //mast pot port
    public static int liftPotPort = 0;

    //port for suction cup piston
    public static int cupsCylinder = 0;
    //port for intake piston
    public static int intakeCylinder = 1;
    //port for brake cylinder
    public static int brakeCylinder = 2;
    //port for climb release cylinder
    public static int climbReleaseCylinder = 3;
 
    //xbox controller ports
    public static int xboxControllerPort = 0;
    public static int auxXboxControllerPort = 1;

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
    public static int maxMastHeight = 8;
    public static int minMastHeight = 7;


    }


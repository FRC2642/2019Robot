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
    //ID for wrist motor
    public static final int ID_WRIST = 4;
    //ID for intake motors
    public static final int ID_INTAKE_MASTER = 8;
    public static final int ID_INTAKE_SLAVE = 9;
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
    
    //port for light sensors
    public static int lightSensorPort = 0; 
    //mast pot port
    public static int mastPotPort = 0;
    //wrist pot port
    public static int wristPotPort = 1;

    //port for suction cup piston
    public static int cupsCylinderPort = 6;
    //ports for wrist piston
    public static int wristCylinderPort = 7;
    //port for brake cylinder
    public static int brakeCylinderPort = 0;
    //ports for fang cylinder
    public static int fangCylinderPort = 2;
    //ports for vaccum cylinder
    public static int vacuumCylinderPort = 1;
 
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
    public static double maxMastHeight = 1.0;
    public static double minMastHeight = .101;
    
    //DIO Ports for Limit Switches
    public static final int upperLimitSwitch = 2;
    public static final int lowerLimitSwitch = 4;
    public static final int jackLowerLimitSwitch = 0;
    public static final int intakeLimitSwitch = 6;

    //wrist up and down positions
    public static double wristDownPosition = 0.0;
    public static double wristUpPosition = 1.0;

    //wrist upper and lower limits 
    public static double wristUpperLimit = 1.0;
    public static double wristLowerLimit = 0.0;
    }


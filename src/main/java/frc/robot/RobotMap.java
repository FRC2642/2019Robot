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
    public static final int ID_LEFT_FRONT = 3;
    public static final int ID_LEFT_REAR = 4;
    public static final int ID_RIGHT_FRONT = 1;
    public static final int ID_RIGHT_REAR = 2;
    
    //IDs for mast motors
    public static final int ID_MAST_MASTER = 5;
    public static final int ID_MAST_SLAVE = 6;

    //ID for vacuum motor
    public static final int ID_VACUUM_MOTOR = 7;

    //drive motor limit settings
    public static final boolean IS_CURRENT_LIMIT = false;
    public static final int PEAK_CURRENT = 45;
    public static final int CONTINUOUS_CURRENT = 30;
    public static final int PEAK_CURRENT_DURATION = 200;
    //drive motor voltage settings
    public static final boolean IS_VOLTAGE_COMP = false;
    public static final double VOLTAGE_SATURATION = 12.5;

    //xbox controller port
    public static int xboxControllerPort = 0;

    //# of pulses in 1 rotation
    public static final int PULSES_PER_ROTATION = 4096;
    //length of chain used in one rotation (mast)
    public static float mastChainLength = (float) 5.5;
    public static int liftPotPort = 0;
}

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
    public static int mastPotPort = 3;
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
    //ports for vaccum cylinder
    public static int vacuumCylinderPort = 1;
    //ports for mast cylinder
    public static int mastCylinderPort = 8;
    

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
    public static double minMastHeight = .101;
    
    //DIO Ports for Limit Switches
    public static final int mastUpperLimitSwitch = 2;
    public static final int mastLowerLimitSwitch = 4;
    public static final int jackLimitSwitch = 0;
    public static final int intakeLimitSwitch = 6;

    //panic button values
    public static boolean isMastLimitEnabled = true;

    //PID/drive params
    public static final DriveParameters DRIVE_PARAMS = new DriveParameters(.0058, .0064, .003, -.8);
    public static final PIDParameters TURN_PARAMS_45 = new PIDParameters(.06, .0, -.003, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_90 = new PIDParameters(.005, .002, -.002, 1 / 100.0);
    public static final PIDParameters TURN_PARAMS_180 = new PIDParameters(.06, .003, -.001, 1 / 100.0);

        //Sensor constants
        public final static double PigeonUnitsPerRotation = 8192.0;

        //trajectory point period
        public final static int BaseTrajPeriodMS = 0;
    
        //motion control deadband
        public final static double deadband = 0.001;
    
        //PID Gains
        public final static Gains kGains_Distanc = new Gains( 0.1, 0.0,  0.0, 0.0,            100,  0.50 );
        public final static Gains kGains_Turning = new Gains( 2.0, 0.0,  4.0, 0.0,            200,  1.00 );
        public final static Gains kGains_Velocit = new Gains( 0.1, 0.0, 20.0, 1023.0/7200.0,  300,  0.50 ); /* measured 6800 velocity units at full motor output */
        public final static Gains kGains_MotProf = new Gains( 0.02, 0.0,  0.2, 1023.0/7200.0,  400,  1.00 ); /* measured 6800 velocity units at full motor output */
    
        /** ---- Flat constants, you should not need to change these ---- */
        /* We allow either a 0 or 1 when selecting an ordinal for remote devices [You can have up to 2 devices assigned remotely to a talon/victor] */
        public final static int REMOTE_0 = 0;
        public final static int REMOTE_1 = 1;
        /* We allow either a 0 or 1 when selecting a PID Index, where 0 is primary and 1 is auxiliary */
        public final static int PID_PRIMARY = 0;
        public final static int PID_TURN = 1;
        /* Firmware currently supports slots [0, 3] and can be used for either PID Set */
        public final static int SLOT_0 = 0;
        public final static int SLOT_1 = 1;
        public final static int SLOT_2 = 2;
        public final static int SLOT_3 = 3;
        /* ---- Named slots, used to clarify code ---- */
        public final static int kSlot_Distanc = SLOT_0;
        public final static int kSlot_Turning = SLOT_1;
        public final static int kSlot_Velocit = SLOT_2;
        public final static int kSlot_MotProf = SLOT_3;
    
        //timeout
        public final static int timeOut = 30;
        
        
        //needed numbers for math involved with motion control
        public static final double DIAMETER = 6; // wheel diameter in inches
        public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
        public static final int PULSE_PER_ROTATION = 512; //needs testing 8-11-18
        public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;
        public static final double WHEEL_TRACK = 27; // guess, needs measurment 8-11-18
    
        // Default cruise velocity and acceleration
        // TESTBED 2/10- on carpet for 252 and 101, F = 1.5, P = 0.01, I = 0, D = 0
        // TESTBED CV = 1280, ACCEL = 1280 Margin = 20
        //coast standard numer for motion profiling (ie coast 200 encoder turns before hard stop)
        public static final int M_MAGIC_CV = 200;
        //set acceleration constant
        public static final int M_MAGIC_ACCL = 1000;
    
        // Linear motion magic parameters
        //change to OG PID #
        public static final double M_MAGIC_K_P = 0.6; 
        public static final double M_MAGIC_K_I = 0.0;
        public static final double M_MAGIC_K_D = 0.0;
        public static final double M_MAGIC_K_F_R = 1.9; 
        public static final double M_MAGIC_K_F_L = 1.8; 
    
        // Pathfinder gains
        
        public static final double DT = 1 / 50.0;
        public static final double kP = 0.01;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double kV = 0.001;
        public static final double kA = 0.001;
    
        public static final double kTurn = 0.01;
    }


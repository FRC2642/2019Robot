/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
put name and message below and push to git
anisha sadhale hello ppl
sean jung hi everyone
Joseph Sowers Bonkey Dong Kongos


git 


*/
package frc.robot;

import java.nio.channels.spi.AbstractSelector;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.commands.auto.Cross;
import frc.commands.drive.DriveCommand;
import frc.subsystems.BrakeSubsystem;
import frc.subsystems.DriveSubsystem;
import frc.subsystems.FangSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.MastSubsystem;
import frc.subsystems.ThrustSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public PowerDistributionPanel pdp = new PowerDistributionPanel(0);

  public static DriveSubsystem drive = new DriveSubsystem();
  public static MastSubsystem mast = new MastSubsystem();
  public static IntakeSubsystem intake = new IntakeSubsystem();
  public static ThrustSubsystem thrust = new ThrustSubsystem();
  public static BrakeSubsystem brake = new BrakeSubsystem();
  public static FangSubsystem fang = new FangSubsystem();
 
  public Compressor compressor = new Compressor(RobotMap.ID_PCM);
  

  public static OI oi = new OI();

  Command m_autonomousCommand;

//	SendableChooser<Command> m_chooser = new SendableChooser<>();
  

 

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
    cam.setExposureManual(50);
    cam.setResolution(320, 240);
    cam.setFPS(20);
   // m_chooser.setDefaultOption("Default Auto", Cross);
   // m_chooser.addOption("My Auto", DriveCommand);
    SmartDashboard.putData("Auto choices", m_chooser);
    
    compressor.start();

    
  
	

  }


  

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void teleopInit() {
    super.teleopInit();

  }
  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    
    teleopInit();
 
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
   teleopPeriodic();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    SmartDashboard.putNumber("mastPot", mast.mastPot.get());
    SmartDashboard.putBoolean("lightSensor", drive.getLightSensor());
    /*
    SmartDashboard.putBoolean("mastLimitSwitchDown", mast.getLowerLimitSwitch());
    SmartDashboard.putBoolean("mastLimitSwitchUp", mast.getUpperLimitSwitch());
    SmartDashboard.putBoolean("intakeLimitSwitch", intake.getIntakeLimitSwitch());
    SmartDashboard.putBoolean("jackLimitSwitch", thrust.getJackLimitSwitch());
    */
 

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

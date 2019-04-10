/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.commands.drive.DriveCommand;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CANSparkMax leftMaster, leftSlave;
  public CANSparkMax rightMaster, rightSlave;

  public DifferentialDrive drive;

  public PigeonIMU pigeon;

    public DriveSubsystem(){
      //connected through the ribbon cable onto the talon
     // pigeon = new PigeonIMU();

     leftMaster = new CANSparkMax(RobotMap.ID_LEFT_DRIVE_MASTER, MotorType.kBrushless);
     leftSlave = new CANSparkMax(RobotMap.ID_LEFT_DRIVE_SLAVE, MotorType.kBrushless);
     rightMaster = new CANSparkMax(RobotMap.ID_RIGHT_DRIVE_MASTER, MotorType.kBrushless);
     rightSlave = new CANSparkMax(RobotMap.ID_RIGHT_DRIVE_SLAVE, MotorType.kBrushless);

     drive = new DifferentialDrive(leftMaster, rightMaster);

     leftSlave.follow(leftMaster);
     rightSlave.follow(rightMaster);

     //ramp up? 
    /*
     leftMaster.setOpenLoopRampRate(4);
     rightMaster.setOpenLoopRampRate(4);
      */

      //gyro calibration
      pigeon.enterCalibrationMode(CalibrationMode.BootTareGyroAccel);
    }

    //drive motor methods

  public void setLeftSpeed(double speed) {
    leftMaster.set(speed);
  }

  public void setRightSpeed(double speed){
    rightMaster.set(speed);
  }

  public void stop(){
   setLeftSpeed(0);
   setRightSpeed(0);
  }

  public void arcadeDrive(double speed, double turn) {
   drive.arcadeDrive(speed, turn);
  }

  //sensor methods

  public double getPigeonHeading(){
    return pigeon.getAbsoluteCompassHeading();
  }

  public double getPitch(){
    double[] ypr = new double[3];
    pigeon.getAccelerometerAngles(ypr);
    System.out.println("Pitch: " + ypr[1]);
    return ypr[1];
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }

}

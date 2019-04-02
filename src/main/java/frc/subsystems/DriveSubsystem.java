/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.drive.DriveCommand;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftFrontMaster, leftRearSlave;
  public TalonSRX rightFrontMaster, rightRearSlave;

  PigeonIMU pigeon = new PigeonIMU(RobotMap.ID_PIGEON);

    public DriveSubsystem(){
      leftFrontMaster = new TalonSRX(RobotMap.ID_LEFT_FRONT_DRIVE);
      leftRearSlave = new TalonSRX(RobotMap.ID_LEFT_REAR_DRIVE);
      rightFrontMaster = new TalonSRX(RobotMap.ID_RIGHT_FRONT_DRIVE);
      rightRearSlave = new TalonSRX(RobotMap.ID_RIGHT_REAR_DRIVE);

      //gyro calibration
      pigeon.enterCalibrationMode(CalibrationMode.BootTareGyroAccel);
      //set master-slave motors
      leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
      rightRearSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());
      //limit settings
      leftFrontMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
      leftFrontMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
      leftFrontMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
      leftFrontMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
      //voltage compensation settings
      rightFrontMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
      rightFrontMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
      rightFrontMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
      rightFrontMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
      //deadband settings
      rightFrontMaster.configNeutralDeadband(.1);
      leftFrontMaster.configNeutralDeadband(.1);

      // rightFrontMaster.setInverted(true);
      // leftFrontMaster.setInverted(true);
    }

  public void setLeftSpeed(double speed) {
    leftFrontMaster.set(ControlMode.PercentOutput, speed);
  }

  public void setRightSpeed(double speed){
    rightFrontMaster.set(ControlMode.PercentOutput, speed);
  }

  public void stop(){
    setLeftSpeed(0);
    setRightSpeed(0);
  }

  public void arcadeDrive(double speed, double turn) {
    turn = -turn;
    leftFrontMaster.set(ControlMode.PercentOutput, turn, DemandType.ArbitraryFeedForward, speed);
    rightFrontMaster.set(ControlMode.PercentOutput, turn, DemandType.ArbitraryFeedForward, -speed);
  }

  public double getPigeonHeading(){
    return pigeon.getAbsoluteCompassHeading();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
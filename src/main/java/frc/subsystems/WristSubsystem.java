/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.wrist.MoveWristCommand;
import frc.robot.RobotMap;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class WristSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public VictorSPX wristMotor = new VictorSPX(RobotMap.ID_WRIST);

  public AnalogPotentiometer wristPot = new AnalogPotentiometer(RobotMap.wristPotPort);

  public Solenoid wristCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.wristCylinderPort);

  /*
    public void moveWrist(int position, double speed){
    if(wristPot.get() > position){
    wristMotor.set(ControlMode.PercentOutput, speed);
    } else if(wristPot.get() < position){
      wristMotor.set(ControlMode.PercentOutput, -speed);
    }
  }*/

  public double getWristPot(){
     return wristPot.get();
  }
  
  public void moveWrist(double speed){
    if(speed > 0 && Robot.wrist.getWristPot() < RobotMap.wristUpperLimit){
       wristMotor.set(ControlMode.PercentOutput, speed);
    } else if(speed < 0 && Robot.wrist.getWristPot() > RobotMap.wristLowerLimit){
      wristMotor.set(ControlMode.PercentOutput, speed);
    } else {
      stop();
    }
  }

  public void stop(){
    wristMotor.set(ControlMode.PercentOutput, 0);
  }
  public void wristOut(){
    wristCylinder.set(false);
  }

  public void wristIn(){
    wristCylinder.set(true);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveWristCommand());
  }
}

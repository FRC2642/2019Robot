/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimbingSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public VictorSPX climbMotor = new VictorSPX(RobotMap.ID_CLIMB);
public Solenoid clutchCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.climbCylinderPort);

public void clutchIn() {
  clutchCylinder.set(true);
}

public void clutchOut() {
  clutchCylinder.set(false);
}
/*
public void setClutch(){
  if(OI.aux.getRawButton(3)){
    clutchCylinder.set(true);
  } else{
    clutchCylinder.set(false);
  }
}*/

public void climb(double speed){
  climbMotor.set(ControlMode.PercentOutput, speed);
}

public void stop(){
  climbMotor.set(ControlMode.PercentOutput, 0);
}


@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new ClimbCommand());
  }
}

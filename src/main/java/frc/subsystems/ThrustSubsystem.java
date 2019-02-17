/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * This is actually the Climbing system
 * these kids (meaning joseph) don't know how to make good names that make sense
 */
public class ThrustSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public VictorSPX jackMaster = new VictorSPX(RobotMap.ID_JACK);
public VictorSPX rollerMaster = new VictorSPX(RobotMap.ID_ROLLER);

public AnalogPotentiometer mastPot = new AnalogPotentiometer(RobotMap.mastPotPort); 
  public DigitalInput lowerLimitSwitch = new DigitalInput(RobotMap.lowerLimitSwitch);
  public Counter counter = new Counter(lowerLimitSwitch);

  public ThrustSubsystem() {
  }
    
  public void jackUp() {
      jackMaster.set(ControlMode.PercentOutput, 1);
    }
    
    public void jackDown() {
      jackMaster.set(ControlMode.PercentOutput, -1);
    }

  public void rollerRolling() {
    rollerMaster.set(ControlMode.PercentOutput, 0.95);
  }
  public void stop() {
    rollerMaster.set(ControlMode.PercentOutput, 0);
    jackMaster.set(ControlMode.PercentOutput, 0);
  }

  //Limit Switch stuff
  public boolean isUpperSwitchSet()  {
    return counter.get() > 0;
  }
  
  public void initializeCounter() {
    counter.reset();
  }
  public boolean lowerSwitchSet() {
    return counter.get() > 0;
  }


  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

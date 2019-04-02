/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.thrust.RollerCommand;
import frc.robot.OI;
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

public DigitalInput jackLimitSwitch = new DigitalInput(RobotMap.jackLimitSwitchPort);

  public ThrustSubsystem() {
  }

  public void jackUp() {
      jackMaster.set(ControlMode.PercentOutput, -0.5);
    }
    
    public void jackDown() {
      if(getJackLimitSwitch()){
        stopJack();
      } else {
      jackMaster.set(ControlMode.PercentOutput, 0.5);
      }
    }

  public void rollRoller() {
    //B button
    if(OI.xbox.getRawButton(7)){
      rollerMaster.set(ControlMode.PercentOutput, -.9);
    } else{
      stopRoller();
    }
  }

  public void stopRoller(){
    rollerMaster.set(ControlMode.PercentOutput, 0);
  }

  public void stopJack() {
    jackMaster.set(ControlMode.PercentOutput, 0);
  }


  public boolean getJackLimitSwitch(){
    return !jackLimitSwitch.get();
  }


  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new RollerCommand());
  }
}

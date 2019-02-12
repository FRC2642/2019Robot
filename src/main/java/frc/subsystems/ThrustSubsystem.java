/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ThrustSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public TalonSRX jackMaster = new TalonSRX(RobotMap.ID_JACK);
public TalonSRX rollerMaster = new TalonSRX(RobotMap.ID_ROLLER);
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


  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

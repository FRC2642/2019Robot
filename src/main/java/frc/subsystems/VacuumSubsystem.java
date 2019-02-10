/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.vacuum.SuccOffCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class VacuumSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
// here. Call these from Commands.
public VictorSPX vacuumMaster = new VictorSPX(RobotMap.ID_VACUUM_MOTOR);

  public VacuumSubsystem() {
    
  }

public void succOn() {
  vacuumMaster.set(ControlMode.PercentOutput, 0.97);
}

public void succOff() {
  vacuumMaster.set(ControlMode.PercentOutput, 0);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new SuccOffCommand());

  }
}

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
import frc.commands.intake.IntakeCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {

  public VictorSPX frontMaster = new VictorSPX(RobotMap.ID_FRONT_MASTER);
  public VictorSPX shooterMaster = new VictorSPX(RobotMap.ID_SHOOTER_MASTER);

  public DigitalInput intakeSwitch = new DigitalInput(RobotMap.intakeLimitSwitch);
  
  public IntakeSubsystem() {
  }

  public void intake() {
    frontMaster.set(ControlMode.PercentOutput, 0.6);
    shooterMaster.set(ControlMode.PercentOutput, 0.6);
  }

  public void outtake() {
    shooterMaster.set(ControlMode.PercentOutput, -0.6);
  }

  public void stop() {
    frontMaster.set(ControlMode.PercentOutput, 0);
    shooterMaster.set(ControlMode.PercentOutput, 0);
  }

  
public boolean limitSwitchState(){
  return !intakeSwitch.get();
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new IntakeCommand());
  }
}

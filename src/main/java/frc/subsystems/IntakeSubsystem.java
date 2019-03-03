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

  public VictorSPX intakeMaster = new VictorSPX(RobotMap.ID_INTAKE_MASTER);
  public VictorSPX intakeSlave = new VictorSPX(RobotMap.ID_INTAKE_SLAVE);

  public DigitalInput intakeSwitch = new DigitalInput(RobotMap.intakeLimitSwitch);
  
  public IntakeSubsystem() {
    intakeSlave.set(ControlMode.Follower, intakeMaster.getDeviceID());
  }

  public void intake() {
    intakeMaster.set(ControlMode.PercentOutput, 0.6);
  }

  public void outtake() {
    intakeMaster.set(ControlMode.PercentOutput, -0.6);
  }

  public void stop() {
    intakeMaster.set(ControlMode.PercentOutput, 0);
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

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;


/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public VictorSPX intakeMaster = new VictorSPX(RobotMap.ID_INTAKE_MOTOR);
 Solenoid intakeCylinder = new Solenoid(RobotMap.ID_SOLENOID)
 public intakeSubsystem() {
 }

  public void Outtake() {
    intakeMaster.set(ControlMode.PercentOutput, 0.6);
  }
    public void outtake() {
      intakeMaster.set(ControlMode.PercentOutput, 0.6);
    }

public void stop() {
  intakeMaster.set(ControlMode.PercentOutput, 0);
}

public void closeIntake() {
  intake.set(true);
}
public void openIntake() {
  intake.set(false);
}
 

 
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand();
  }
}

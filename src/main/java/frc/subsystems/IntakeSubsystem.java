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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.intake.IntakeCommand;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {

  public VictorSPX frontMaster = new VictorSPX(RobotMap.ID_FRONT_MASTER);
  public VictorSPX shooterMaster = new VictorSPX(RobotMap.ID_SHOOTER_MASTER);

  public Solenoid hatchCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.hatchCylinderPort);

  public DigitalInput intakeSwitch = new DigitalInput(RobotMap.intakeLimitSwitchPort);
  
    public IntakeSubsystem() {
    }

  //intake wheels methods 

  public void intakeIn() {
    frontMaster.set(ControlMode.PercentOutput, -0.8);
    shooterMaster.set(ControlMode.PercentOutput, 0.8);
  }

  public void intakeOut() {
    shooterMaster.set(ControlMode.PercentOutput, -0.8);
  }

  public void stop() {
    frontMaster.set(ControlMode.PercentOutput, 0);
    shooterMaster.set(ControlMode.PercentOutput, 0);
  }

  //hatch finger method
 
  public void flipFinger(){
    if(OI.aux.getRawButton(4)){
      hatchCylinder.set(false);
    } 
    else if(OI.aux.getRawButton(3)){
      hatchCylinder.set(true);
    }
  }
  
  //limit switch method

  public boolean getIntakeLimitSwitch(){
    return !intakeSwitch.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new IntakeCommand());
  }
}

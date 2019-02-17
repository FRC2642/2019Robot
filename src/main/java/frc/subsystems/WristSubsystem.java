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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.wrist.MoveWristCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class WristSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public VictorSPX wristMotor = new VictorSPX(RobotMap.ID_WRIST);

  public AnalogPotentiometer wristPot = new AnalogPotentiometer(RobotMap.wristPotPort);

  public DoubleSolenoid wristCylinder = new DoubleSolenoid(RobotMap.wristCylinderPort1, RobotMap.wristCylinderPort2);

  


    public void moveWrist(int position, double speed){
    if(wristPot.get() > position){
    wristMotor.set(ControlMode.PercentOutput, speed);
    } else if(wristPot.get() < position){
      wristMotor.set(ControlMode.PercentOutput, -speed);
    }
  }

  public void moveWristDown(){
    moveWrist(RobotMap.wristDownPosition, .8);
  }

  public void moveWristUp(){
    moveWrist(RobotMap.wristUpPosition, .8);
  }

  public void wristOut(){
    wristCylinder.set(Value.kForward);
  }

  public void wristIn(){
    wristCylinder.set(Value.kReverse);
  }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveWristCommand());
  }
}

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
import frc.commands.climb.ManualClimbCommand;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimbingSubsystem extends Subsystem {

  public VictorSPX jackMaster = new VictorSPX(RobotMap.ID_JACK);
  public VictorSPX rollerMaster = new VictorSPX(RobotMap.ID_ROLLER);

  public VictorSPX frontClimbMaster = new VictorSPX(RobotMap.ID_FRONT_CLIMB);
/*
  public DoubleSolenoid climbCylinder = new DoubleSolenoid(RobotMap.ID_PCM, RobotMap.climbCylinderForwardChannel, 
                                                           RobotMap.climbCylinderBackwardChannel);
  */
  public DigitalInput jackLimitSwitch = new DigitalInput(RobotMap.jackLimitSwitchPort);
   
      public ClimbingSubsystem() {
       // climbPID.setSetpoint(0);
      }
  
  //jack (rear climb) methods

  public void jackUp() {
    jackMaster.set(ControlMode.PercentOutput, -0.5);
  }
      
  public void jackDown() {
      jackMaster.set(ControlMode.PercentOutput, 0.5);
  }

   public void stopJack() {
    jackMaster.set(ControlMode.PercentOutput, 0);
  }

  //roller (wheels under jack) methods

  public void rollRoller() {
    if(OI.xbox.getRawButton(7)){
      rollerMaster.set(ControlMode.PercentOutput, -1.0);
    } else{
      stopRoller();
    }
  }
  
  public void stopRoller(){
    rollerMaster.set(ControlMode.PercentOutput, 0);
  }

  //front climb methods

  public void moveFrontClimb(double speed){
    frontClimbMaster.set(ControlMode.PercentOutput, speed);
  }
  
  public void moveFrontClimbUp(){
    moveFrontClimb(.85);
  }

  public void moveFrontClimbDown(){
    moveFrontClimb(-.85);
  }

  public void stopFrontClimb(){
    frontClimbMaster.set(ControlMode.PercentOutput, 0);
  }

  /*
  //backup climb methods

  public void climbCylinderUp(){
    climbCylinder.set(Value.kForward);
  }

  public void climbCylinderDown(){
    climbCylinder.set(Value.kReverse);
  }
  */

  //limit switch method

  public boolean getJackLimitSwitch(){
    return jackLimitSwitch.get();
  }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualClimbCommand());
  }

}

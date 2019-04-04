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
import frc.library.lib.pid.PID;
import frc.library.lib.pid.PIDOutput;
import frc.library.lib.pid.PIDSource;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimbingSubsystem extends Subsystem implements PIDSource, PIDOutput {

  public VictorSPX jackMaster = new VictorSPX(RobotMap.ID_JACK);
  public VictorSPX rollerMaster = new VictorSPX(RobotMap.ID_ROLLER);
  public VictorSPX frontClimbMaster = new VictorSPX(RobotMap.ID_FRONT_CLIMB);
  
  public DigitalInput jackLimitSwitch = new DigitalInput(RobotMap.jackLimitSwitchPort);

                                                //probably needs P and I definitely, maybe small D
  public static PID climbPID = new PID(Robot.climb, Robot.climb, RobotMap.CLIMB_PARAMS);
   
      public ClimbingSubsystem() {
        climbPID.setSetpoint(0);
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
      rollerMaster.set(ControlMode.PercentOutput, -.9);
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
    moveFrontClimb(-.5);
  }

  public void moveFrontClimbDown(){
    moveFrontClimb(.5);
  }

  public void stopFrontClimb(){
    frontClimbMaster.set(ControlMode.PercentOutput, 0);
  }

  public void enablePID(){
    climbPID.enable();
  }

  public void disablePID(){
    climbPID.disable();
  }
  
  //limit switch method

  public boolean getJackLimitSwitch(){
    return jackLimitSwitch.get();
  }

  //sensor methods

  @Override
  public double pidGet() {
    return Robot.drive.getPitch();
  }

  @Override
  public void pidSet(double speed) {
    moveFrontClimb(speed);
  }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualClimbCommand());
  }

}

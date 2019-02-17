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
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.commands.mast.LiftCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class MastSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public VictorSPX mastMaster = new VictorSPX(RobotMap.ID_MAST_MASTER);
  public VictorSPX mastSlave = new VictorSPX(RobotMap.ID_MAST_SLAVE);

  public AnalogPotentiometer liftPot = new AnalogPotentiometer(RobotMap.liftPotPort); 


  public MastSubsystem(){
    mastSlave.set(ControlMode.Follower, mastMaster.getDeviceID());
    
    
    }
    
    public void setMastSpeed(double speed){
      mastMaster.set(ControlMode.PercentOutput, speed * .6);
      }
      
    
      public void stop(){
        setMastSpeed(0);
      }
    
      public void lift(double lift){
      }

      
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftCommand());
  }

  
  protected double returnPIDInput() {
    return liftPot.pidGet();
  }

  protected void usePIDOutput(double output) {
    moveLift(output);
  }

  //Raises or lowers lift
  public void moveLift(double speed) {
    if ((speed > 0) && (liftPot.get() > RobotMap.minMastHeight)) {
      mastMaster.set(ControlMode.PercentOutput, speed);
    }
    else if ((speed < 0) && (liftPot.get() < RobotMap.maxMastHeight)) {
      mastMaster.set(ControlMode.PercentOutput, speed);
    }
    else {
      stop();
    }
  }
  public void moveToSetPosition(double pulses){
    if(liftPot.get() > pulses) {
    moveLift(-0.8);
    }
    else if(liftPot.get() < pulses) { 
    moveLift(0.8);      
    } else {
      Robot.brake.brakeOn();
    }
    }
      
    
  
  //Moves the mast to the three loading levels for the cargo on the rocket.
  public void moveMastToCargoBottomPosition() {
    moveToSetPosition(27.5);
  }
  public void moveMastToCargoMiddlePosition() {
    moveToSetPosition(55.5);
  }
  public void moveMastToCargoTopPosition() {
    moveToSetPosition(83.5);
  }
  //Moves the mast to the three loading levels for the hatches on the rocket.
  public void moveMastToHatchBottomPosition() {
    moveToSetPosition(19);
  }
  public void moveMastToHatchMiddlePosition() {
    moveToSetPosition(47);
  }
  public void moveMastToHatchTopPosition() {
    moveToSetPosition(65);
  }
  //Moves mast to hatch level for the cargo ship.
  public void moveMastToShipHatch() {
    moveToSetPosition(16.25);
  }
  //Moves mast to the cargo level for the cargo ship.
  public void moveMastToShipCargo() {
    moveToSetPosition(39.75);
  }



  }





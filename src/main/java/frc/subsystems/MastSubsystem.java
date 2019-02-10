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
import frc.commands.mast.LiftCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class MastSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX mastMaster = new TalonSRX(RobotMap.ID_MAST_MASTER);
  public TalonSRX mastSlave = new TalonSRX(RobotMap.ID_MAST_SLAVE);


  public MastSubsystem(){
    mastSlave.set(ControlMode.Follower, mastMaster.getDeviceID());
    
    mastMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
    mastMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
    mastMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
    mastMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
    }
    
    public void setMastSpeed(double speed){
      mastMaster.set(ControlMode.PercentOutput, speed * .6);
      }
      
    
      public void stop(){
        setMastSpeed(0);
      }
    
      public void lift(double lift){
        setMastSpeed(lift);
      }
     
      //this takes inches from the bottom of mast as input and turns it into pulses 
      // on a 22-tooth sprocket + chain links w/ .25 inch pitch 
      public void moveToPosition(float inches, int pidIndex, int timeout){
        
        int pulses = Math.round((RobotMap.PULSES_PER_ROTATION / RobotMap.mastChainLength) * inches);
        mastMaster.setSelectedSensorPosition(pulses, pidIndex, timeout);
      }

      public void moveMastToBottomPosition(){
        moveToPosition((float) 27.5, 0, 0);
      }

      public void moveMastToMiddlePosition(){
        moveToPosition((float) 55.5, 0, 0);
      }

      public void moveMastToTopPosition(){
        moveToPosition((float) 83.5, 0, 0);
      }
    
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftCommand());
  }
}

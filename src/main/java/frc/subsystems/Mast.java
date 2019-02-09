/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Mast extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX mastMaster = new TalonSRX(RobotMap.ID_MAST_MASTER);
  public TalonSRX mastSlave = new TalonSRX(RobotMap.ID_MAST_SLAVE);


  public Mast(){
    mastSlave.set(ControlMode.Follower, mastMaster.getDeviceID());
    
    mastMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
    mastMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
    mastMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
    mastMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
    }
    
    public void setMastSpeed(double speed){
      mastMaster.set(ControlMode.PercentOutput, speed);
      }
      
    
      public void stop(){
        setMastSpeed(0);
      }
    
      public void lift(double lift){
        setMastSpeed(lift);
      }
     
      
    
    

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

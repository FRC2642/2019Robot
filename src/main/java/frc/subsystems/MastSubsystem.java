/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
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
  public TalonSRX mastMaster = new TalonSRX(RobotMap.ID_MAST_MASTER);
  public TalonSRX mastSlave = new TalonSRX(RobotMap.ID_MAST_SLAVE);

 public Solenoid mastCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.mastCylinderPort);

  public AnalogPotentiometer mastPot = new AnalogPotentiometer(RobotMap.mastPotPort); 
  public DigitalInput mastUpperLimitSwitch = new DigitalInput(RobotMap.mastUpperLimitSwitch);
  public DigitalInput mastLowerLimitSwitch = new DigitalInput(RobotMap.mastLowerLimitSwitch);
  
  //mast piston
  public Solenoid mastCylinder = new Solenoid(RobotMap.ID_PCM, RobotMap.mastCylinderPort);

  public void mastPistonUp() {
        mastCylinder.set(true);
  }
public void mastPistonDown() {
      mastCylinder.set(false);
}
  public MastSubsystem(){
    mastSlave.set(ControlMode.Follower, mastMaster.getDeviceID());

  //set limit stuff
  mastMaster.enableCurrentLimit(RobotMap.IS_CURRENT_LIMIT);
  mastMaster.configContinuousCurrentLimit(RobotMap.CONTINUOUS_CURRENT, 0);
  mastMaster.configPeakCurrentLimit(RobotMap.PEAK_CURRENT, 10);
  mastMaster.configPeakCurrentDuration(RobotMap.PEAK_CURRENT_DURATION, 10);
  //set deadband
  mastMaster.configNeutralDeadband(.1);
      }
  
  protected double returnPIDInput() {
    return mastPot.pidGet();
  }

  protected void usePIDOutput(double output) {
    moveLift(output);
  }

  //Raises or lowers lift
  public void moveLift(double speed) {
    if(RobotMap.isMastLimitEnabled){
     // speed = -speed;
       if( (speed < 0) && ((mastPot.get() >= RobotMap.maxMastHeight || !getUpperLimitSwitch())) ){
        stop();
      } else if( (speed > 0) && ((mastPot.get() <= RobotMap.minMastHeight || !getLowerLimitSwitch())) ){
        stop();
      } else {
        mastMaster.set(ControlMode.PercentOutput, speed);
      }
    } else {
      if( (speed > 0) && getUpperLimitSwitch() ){
        stop();
      }
      else if( (speed < 0) && getLowerLimitSwitch() ){
        stop();
      } else {
        mastMaster.set(ControlMode.PercentOutput, speed);
      }
    } 
  }

  public void moveToSetPosition(double pulses){
    //tolerance
    double rangeHigh = pulses + 10;
    double rangeLow = pulses - 10;

    if(mastPot.get() > rangeHigh) {
    moveLift(-0.8);
    }
    else if(mastPot.get() < rangeLow) { 
    moveLift(0.8);      
    } else {
      Robot.brake.brakeOn();
    }
    }

    public void stop(){
      mastMaster.set(ControlMode.PercentOutput, 0);
    }

    public boolean getUpperLimitSwitch(){
      return mastUpperLimitSwitch.get();
    }

    public boolean getLowerLimitSwitch(){
      return mastLowerLimitSwitch.get();
    }

    public void mastCylinderUp(){
      mastCylinder.set(true);
      
    }

    public void mastCylinderDown(){
      mastCylinder.set(false);
   
    }

    public boolean getMast(){
      return mastCylinder.get();
    }
  
    //put these in robot map
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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftCommand());
  }

  }





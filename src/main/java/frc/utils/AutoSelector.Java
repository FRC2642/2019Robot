
    /*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utils;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class AutoSelector {
    
    public Command autoCommand;

    //all starting positions and what to do
    public boolean isCargoCargo() {
        if(OI.dial1.get()) {
            return true;
        } else { 
            return false;
        }
    }
    
    public boolean isHatchHatch() {
        if(OI.dial2.get()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isHatchCargo() {
        if(OI.dial3.get()) {
            return true;
        } else { 
            return false;
        }
    }
    
    public boolean isCargoHatch() {
        if(OI.dial4.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    //Starting Places for robot
    public boolean isAtLowLeft() {
        if(OI.dial5.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtLowCenter() {
        if(OI.dial6.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtLowRight() {
        if(OI.dial7.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtHighLeft() {
        if(OI.dial8.get()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtHighRight() {
        if(OI.dial9.get()) {
            return true;
        } else { 
            return false;
        }
    }
    //order of things to do 
    public boolean isAtShipShip() {
        if(OI.dial10.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isAtShipRocket() {
        if(OI.dial11.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isAtRocketShip() {
        if(OI.dial12.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isRocketRocket() {
        if(OI.dial13.get()) {
            return true;
        } else { 
            return false;
        }
    }

     //TEMP, remove when actual auto is here
   class LStart_LRocket_LRocket extends CommandGroup{}
   class LStart_LRocket_LShip extends CommandGroup{}
   class LStart_LShip_LRocket extends CommandGroup{}
   class LStart_LShip_LShip extends CommandGroup{}

    public void selectAuto() {
    
    if(isAtHighLeft){
        autoCommand = new Cross();
    }
   
    /*
    if (isCargoCargo() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoCargo() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isCargoCargo() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoCargo() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoCargo() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoCargo() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoCargo() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoCargo() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoCargo() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isCargoCargo() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isCargoCargo() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isCargoCargo() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoCargo() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoCargo() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoCargo() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoCargo() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchHatch() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isHatchHatch() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchHatch() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchHatch() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchHatch() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchHatch() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isHatchHatch() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isHatchHatch() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isHatchHatch() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchHatch() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchHatch() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchHatch() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchHatch() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }
    if (isHatchCargo() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchCargo() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isHatchCargo() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchCargo() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchCargo() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchCargo() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchCargo() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchCargo() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchCargo() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isHatchCargo() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isHatchCargo() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isHatchCargo() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isHatchCargo() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isHatchCargo() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isHatchCargo() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isHatchCargo() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }
   
    if (isCargoHatch() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoHatch() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isCargoHatch() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoHatch() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoHatch() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoHatch() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoHatch() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoHatch() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoHatch() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isCargoHatch() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isCargoHatch() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isCargoHatch() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    if (isCargoHatch() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isCargoHatch() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isCargoHatch() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isCargoHatch() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    }
    */
}

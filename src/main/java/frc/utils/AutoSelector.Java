
    /*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.utils;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class AutoSelector {
    
    public Command autoCommand;
/*
    //all starting positions and what to do
    public boolean isLoadCargo() {
        if(OI.dial1.get()) {
            return true;
        } else { 
            return false;
        }
    }
    
    public boolean isLoadHatch() {
        if(OI.dial2.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    //Starting Places for robot
    public boolean isAtLowLeft() {
        if(OI.dial3.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtLowCenter() {
        if(OI.dial4.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtLowRight() {
        if(OI.dial5.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isAtHighLeft() {
        if(OI.dial6.get()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtHighRight() {
        if(OI.dial7.get()) {
            return true;
        } else { 
            return false;
        }
    }
    //order of things to do 
    public boolean isAtShipShip() {
        if(OI.dial8.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isAtShipRocket() {
        if(OI.dial9.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isAtRocketShip() {
        if(OI.dial10.get()) {
            return true;
        } else { 
            return false;
        }
    }
    public boolean isRocketRocket() {
        if(OI.dial11.get()) {
            return true;
        } else { 
            return false;
        }
    }

    public void selectAuto() {
    //Low left start L1
    //LEVEL 1!!
    //LEVEL 1!!
    //LEVEL 1!!
    //CARGO!!!!!!!!!!!!
   
    if (isLoadCargo() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadCargo() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isLoadCargo() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadCargo() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L1
    if (isLoadCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    

    //Low Right L1
    if (isLoadCargo() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadCargo() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadCargo() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadCargo() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //LEVEL 2!!!
    //High Left L2
    //LEVEL 2!!!!!!!!
    //CARGO!!!!!!
    if (isLoadCargo() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isLoadCargo() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isLoadCargo() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isLoadCargo() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }


    //Center Start L2
    if (isLoadCargo() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadCargo() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L2
    if (isLoadCargo() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadCargo() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadCargo() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadCargo() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }


    //Low left start L1
    //LEVEL 1!!
    //LEVEL 1!!!!!!
    //HATCH!!!!!!!!
   
    //Low Left Start L1
    if (isLoadHatch() && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadHatch() && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (isLoadHatch() && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadHatch() && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L1
    if (isLoadHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

     //Low Right L1
    if (isLoadHatch() && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadHatch() && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadHatch() && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadHatch() && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //LEVEL 2!!!
    //High Left L2
    //LEVEL 2!!!!!!!
    //HATCH!!!!!!
    if (isLoadHatch() && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (isLoadHatch() && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (isLoadHatch() && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (isLoadHatch() && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    
    //Center Start L2
    if (isLoadHatch() && isAtLowCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadHatch() && isAtLowCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L2
    if (isLoadHatch() && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (isLoadHatch() && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (isLoadHatch() && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (isLoadHatch() && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }


}*/
}


    /*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.OI;
/**
 * Add your docs here.
 */
public class AutoSelector {
    boolean isLoadCargo = false;




    


    //all starting positions and what to do
    public boolean isLoadCargo() {
        if(OI.dial1.get()) {
            return true;
        } else { 
            return false;
        }
    }
    
    public boolean isLoadCargo() {
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
    //High left start L1
    //LEVEL 1!!
    //LEVEL 1!!
    //LEVEL 1!!
    //CARGO!!!!!!!!!!!!
    if (ifLoadCargo && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (ifLoadCargo && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (ifLoadCargo && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (ifLoadCargo && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Left Start L1
    if (ifLoadCargo && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (ifLoadCargo && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L1
    if (ifLoadCargo && isAtCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L1
    if (ifLoadCargo && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Right L1
    if (ifLoadCargo && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //LEVEL 2!!!
    //High Left L2
    //LEVEL 2!!!!!!!!
    //CARGO!!!!!!
    if (ifLoadCargo && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (ifLoadCargo && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (ifLoadCargo && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (ifLoadCargo && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Left Start L2
    if (ifLoadCargo && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (ifLoadCargo && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L2
    if (ifLoadCargo && isAtCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L2
    if (ifLoadCargo && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Right L2
    if (ifLoadCargo && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadCargo && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadCargo && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadCargo && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }





    //High left start L1
    //LEVEL 1!!
    //LEVEL 1!!!!!!
    //HATCH!!!!!!!!
    if (ifLoadHatch && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (ifLoadHatch && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (ifLoadHatch && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (ifLoadHatch && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Left Start L1
    if (ifLoadHatch && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (ifLoadHatch && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L1
    if (ifLoadHatch && isAtCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L1
    if (ifLoadHatch && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Right L1
    if (ifLoadHatch && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //LEVEL 2!!!
    //High Left L2
    //LEVEL 2!!!!!!!
    //HATCH!!!!!!
    if (ifLoadHatch && isAtHighLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }
    
    if (ifLoadHatch && isAtHighLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
   
    if (ifLoadHatch && isAtHighLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }
    
    if (ifLoadHatch && isAtHighLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Left Start L2
    if (ifLoadHatch && isAtLowLeft() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtLowLeft() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }
    
    if (ifLoadHatch && isAtLowLeft() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtLowLeft() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Center Start L2
    if (ifLoadHatch && isAtCenter() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtCenter() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtCenter() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtCenter() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //High Right L2
    if (ifLoadHatch && isAtHighRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtHighRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtHighRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtHighRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

    //Low Right L2
    if (ifLoadHatch && isAtLowRight() && isRocketRocket()) {
        autoCommand = new LStart_LRocket_LRocket();
    }

    if (ifLoadHatch && isAtLowRight() && isAtRocketShip()) {
        autoCommand = new LStart_LRocket_LShip();
    }

    if (ifLoadHatch && isAtLowRight() && isAtShipRocket()) {
        autoCommand = new LStart_LShip_LRocket();
    }

    if (ifLoadHatch && isAtLowRight() && isAtShipShip()) {
        autoCommand = new LStart_LShip_LShip();
    }

}
}

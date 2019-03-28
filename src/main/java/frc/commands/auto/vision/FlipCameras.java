/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto.vision;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class FlipCameras extends InstantCommand {
  /**
   * Add your docs here.
   */
  private boolean cam;

  public void SwitchCameras(boolean cam) {
    this.cam = cam;
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    if(cam){
      CameraServer.getInstance().removeCamera("cam");
      Robot.cam = CameraServer.getInstance().startAutomaticCapture("cam", RobotMap.cam);
      Robot.cam.setFPS(10);
      Robot.cam.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);

    }else{
      CameraServer.getInstance().removeCamera("cam");
      Robot.cam = CameraServer.getInstance().startAutomaticCapture("cam", RobotMap.cam);
      Robot.cam.setFPS(10);
      Robot.cam.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
    }
  }

}

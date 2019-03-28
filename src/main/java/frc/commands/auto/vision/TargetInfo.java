/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto.vision;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetInfo {
    private static int numTargets = 0;
	private static Rect targetRect;
	private static final Object targetImgLock = new Object();
	private static double targetCenterX = Double.MAX_VALUE;
	private static double targetCenterY = Double.MAX_VALUE;
	private static double targetCenterArea = Double.MAX_VALUE;

	public static void setFilterContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (targetImgLock) {
			if (matOfPoints.size() >= 1) {
				numTargets = 1;
				targetRect = Imgproc.boundingRect(matOfPoints.get(0));
				targetCenterX = 2 * targetRect.x + targetRect.width - (RobotMap.IMG_WIDTH / 2);
				targetCenterY = 2 * targetRect.y + targetRect.height - (RobotMap.IMG_HEIGHT / 2);
				targetCenterArea = targetRect.area();
			} else {
				numTargets = 0;
				targetCenterX = Double.MAX_VALUE;
				targetCenterY = Double.MAX_VALUE;
				targetCenterArea = Double.MAX_VALUE;
			}
		}
	}

	public static double gettargetCenterX() {
		return targetCenterX;
	}

	public static double gettargetCenterY() {
		return targetCenterY;
	}

	public static double gettargetCenterArea() {
		return targetCenterArea;
	}

	public static int getNumTargets() {
		return numTargets;
	}
}

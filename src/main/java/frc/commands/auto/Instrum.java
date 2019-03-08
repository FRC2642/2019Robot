/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.auto;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Routines for printing to console (FRC Message log).
 */
public class Instrum {

	static int _loops = 0;

	static boolean _bPrintValues = false;

	public static void printLine(String s) {
		System.out.println(s);
	}

	public static void loop(boolean bPrintValues, TalonSRX talon) {
		if (!_bPrintValues && bPrintValues) {
			/* user just pressed button, immediete print */
			_loops = 999;
		}
		/* if button is off, don't print */
		if (bPrintValues == false) {
			/* reset so we don't print */
			_loops = 0;
		}
		/* save for next compare */
		_bPrintValues = bPrintValues;

		/* build string and print if button is down */
		if (++_loops >= 10) {
			_loops = 0;
			/* get status info */
			MotionProfileStatus status = new MotionProfileStatus();
			talon.getMotionProfileStatus(status);

			String line = "";
			line += "  topBufferRem: " + status.topBufferRem + "\n";
			line += "  topBufferCnt: " + status.topBufferCnt + "\n";
			line += "  btmBufferCnt: " + status.btmBufferCnt + "\n";
			line += "  hasUnderrun: " + status.hasUnderrun + "\n";
			line += "  isUnderrun: " + status.isUnderrun + "\n";
			line += "  activePointValid: " + status.activePointValid + "\n";
			line += "  isLast: " + status.isLast + "\n";
			line += "  profileSlotSelect0: " + status.profileSlotSelect + "\n";
			line += "  profileSlotSelect1: " + status.profileSlotSelect1 + "\n";
			line += "  outputEnable: " + status.outputEnable.toString() + "\n";
			line += "  timeDurMs: " + status.timeDurMs + "\n";

			printLine(line);
		}
	}
}
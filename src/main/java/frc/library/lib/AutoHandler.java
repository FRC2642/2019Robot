package frc.library.lib;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.DigitalInput;

public class AutoHandler {

	private ArrayList<DigitalInput> switches;

	public AutoHandler(int[] _ports) {
		switches = new ArrayList<DigitalInput>();

		for (int port : _ports) {
			switches.add(new DigitalInput(port));
		}
	}

	/**
	 * Convert a decimal number into a binary
	 * 
	 * @param dec
	 *            A decimal number
	 * @return null
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static int[] toBinary(int dec) {
		return null;
	}

	/**
	 * Convert binary number to decimal
	 * 
	 * @param bin
	 *            An array of ints representing a binary number
	 * @return the binary number
	 */
	private static int toDecimal(int[] bin) {
		int sum = 0;
		for (int i = bin.length - 1; i >= 0; i--) {
			sum += bin[i] * Math.pow(2, i);
		}
		return sum;
	}

	public int getSelected() {
		int[] bin = new int[switches.size()];
		int i = 0;
		// Parse switches
		for (DigitalInput toggle : switches) {
			if (!toggle.get()) {
				bin[i] = 1;
			} else {
				bin[i] = 0;
			}
			i++;
		}

		// convert to num
		return toDecimal(bin);
	}
}

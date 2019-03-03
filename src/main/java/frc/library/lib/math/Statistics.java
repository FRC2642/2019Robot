package library.lib.math;

import java.util.List;
/* static class to organize all the math we need 
 *math for the heccing voltage n stuff
 *
 * 
 */

public class Statistics {
	public static double mean(List<Double> data) {
		double sum = 0.0;
		for (Double a : data) {
			sum += a;
		}
		return sum / data.size();
	}
	
	public static double median(List<Double> data) {
		data.sort(null);
		
		if (data.size() % 2 == 0) {
			return (data.get((data.size()/2) - 1) + data.get((data.size()/2))) / 2.0;
		}
		return data.get(data.size() / 2);
	}
	
	public static double variance(List<Double> data) {
		double mean = mean(data);
		double temp = 0;
		for(double a : data) {
			temp += (a-mean) * (a-mean);
		}
		return temp / (data.size() - 1);
	}
	
	public static double standardDev(List<Double> data) {
		return Math.sqrt(variance(data));
	}
}

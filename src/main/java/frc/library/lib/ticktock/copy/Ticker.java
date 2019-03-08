package frc.library.lib.ticktock.copy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A Looper is an easy way to create a timed task the gets called periodically.
 * 
 * Just make a new Looper and give it a Loopable.
 * 
 * @author Tom Bottiglieri
 */
public class Ticker {

	private double period = 1.0 / 100.0;
	protected Tickable tickable;
	private Timer looperUpdater;

	public Ticker(Tickable tickable, double period) {
		this.period = period;
		this.tickable = tickable;
	}

	private class UpdaterTask extends TimerTask {

		private Ticker ticker;

		public UpdaterTask(Ticker ticker) {
			if (ticker == null) {
				throw new NullPointerException("Given Looper was null");
			}
			this.ticker = ticker;
		}

		@Override
		public void run() {
			ticker.update();
		}
	}

	public void start() {
		if (looperUpdater == null) {
			looperUpdater = new Timer();
			looperUpdater.schedule(new UpdaterTask(this), 0L, (long) (this.period * 1000));
		}
	}

	public void stop() {
		if (looperUpdater != null) {
			looperUpdater.cancel();
			looperUpdater = null;
		}
	}

	private void update() {
		tickable.update();
	}
}

package frc.library.lib.oi.triggers;

import edu.wpi.first.wpilibj.buttons.Button;

public class TwoButton extends Button {

	private Button button1, button2;

	public TwoButton(Button _button1, Button _button2) {
		this.button1 = _button1;
		this.button2 = _button2;
	}

	@Override
	public boolean get() {
		return button1.get() && button2.get();
	}

}

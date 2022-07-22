package gui;

import javax.swing.*;

public class Result extends JButton {

	private final int BUTTON_SIZE = 50;
	private final int SPACE_SIZE = 10;

	Result(JTextField output) {
		initResult(output);
	}
	private void initResult(JTextField output) {
		setText("=");
		setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 2,
						 SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 4,
						 BUTTON_SIZE, BUTTON_SIZE);
	}
}

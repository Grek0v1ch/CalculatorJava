package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Back extends JButton {
	private final int BUTTON_SIZE = 50;
	private final int SPACE_SIZE = 10;

	Back(JTextField output) {
		initBack(output);
	}

	private void initBack(JTextField output) {
		setText("<");
		setBounds(SPACE_SIZE,
					   SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 4,
					   BUTTON_SIZE, BUTTON_SIZE);
		addActionWithTExtField(output);
	}

	private void addActionWithTExtField(JTextField output) {
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (output.getText().length() == 0)
					return;
				if (Character.isSpaceChar(output.getText().charAt(output.getText().length() - 1))) {
					output.setText(output.getText().substring(0, output.getText().length() - 3));
					return;
				}
				output.setText(output.getText().substring(0, output.getText().length() - 1));
			}
		};
		addActionListener(l);
	}
}

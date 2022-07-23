package gui;

import calculator.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		addActionWithTExtField(output);
	}

	private void addActionWithTExtField(JTextField output) {
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double result = Calculator.calculateAnswer(output.getText());
				if (result < 0)
					output.setText(" - " + Math.abs((int)result));
				else
					output.setText(Integer.toString((int)result));
			}
		};
		addActionListener(l);
	}
}

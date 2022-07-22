package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
	private final int BUTTON_SIZE = 50;
	private final int SPACE_SIZE = 10;

	private final int MATH_OPERATION = 3;

	Button(String title, JTextField output) {
		createNumbers(title);
		addActionWithTExtField(output);
	}

	private void createNumbers(String title) {
		setText(title);
		setLocation(title);;
	}

	private void setLocation(String title) {
		final int NUMBER = 1;
		if (title.length() == NUMBER) {
			int number = Integer.parseInt(title);
			if (number == 0) {
				setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE),
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 4,
						BUTTON_SIZE, BUTTON_SIZE);
				return;
			}
				setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * ((number - 1) % 3),
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * (number % 3 == 0 ? number / 3 : number / 3 + 1),
						BUTTON_SIZE, BUTTON_SIZE);
				return;
		}
		switch (title) {
			case " - " -> setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 3,
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE),
						BUTTON_SIZE, BUTTON_SIZE);
			case " + " -> setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 3,
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 2,
						BUTTON_SIZE, BUTTON_SIZE);
			case " * " -> setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 3,
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 3,
						BUTTON_SIZE, BUTTON_SIZE);
			case " / " -> setBounds(SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 3,
						SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 4,
						BUTTON_SIZE, BUTTON_SIZE);
		}
	}

	private void addActionWithTExtField(JTextField output) {
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				if (output.getText().length() == 0 && button.getText().length() == MATH_OPERATION) {
					if (button.getText().equals(" - "))
						output.setText(output.getText() + button.getText());
					return;
				}
				if (Character.isSpaceChar(output.getText().charAt(output.getText().length() - 1))) {
					if (button.getText().length() == MATH_OPERATION)
						return;
				}
				output.setText(output.getText() + button.getText());
			}
		};
		addActionListener(l);
	}
}

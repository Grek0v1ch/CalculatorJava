package gui;

import javax.swing.*;

public class Panel extends JPanel {
	private final int BUTTON_SIZE = 50;
	private final int SPACE_SIZE = 10;
	private JTextField output;
	public Panel() {
		setLayout(null);
		initOutput();
		initNumbers();
		initBack();
		initResult();
		initMathOperation();
	}

	private void initNumbers() {
		for (int i = 0; i < 10; i++)
			add(new Button(Integer.toString(i), output));
	}

	private void initBack() {
		add(new Back(output));
	}

	private void initResult() {
		add(new Result(output));
	}

	private void initOutput() {
		output = new JTextField();
		output.setBounds(SPACE_SIZE, SPACE_SIZE, SPACE_SIZE + (BUTTON_SIZE + SPACE_SIZE) * 4, BUTTON_SIZE);
		output.setEditable(false);
		add(output);
	}

	private void initMathOperation() {
		add(new Button(" - ", output));
		add(new Button(" + ", output));
		add(new Button(" * ", output));
		add(new Button(" / ", output));
	}
}

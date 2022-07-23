package calculator;

import java.util.Stack;

public class Calculator {
	public static double calculateAnswer(String exp) {
		return RPNtoAnswer(expressionToRPN(exp));
	}

	public static String expressionToRPN(String exp) {
		StringBuilder current = new StringBuilder();
		Stack<String> stack = new Stack<>();
		String[] data = exp.split(" ");

		int priority;
		for (String item : data) {
			priority = getPriority(item);
			if (priority == 0)
				current.append(item).append(' ');
			if (priority == 1)
				stack.push(item);
			if (priority > 1) {
				while (! stack.empty()) {
					if (getPriority(stack.peek()) >= priority)
						current.append(stack.pop()).append(' ');
					else
						break;
				}
				stack.push(item);
			}
			if (priority == -1) {
				while (getPriority(stack.peek()) != 1)
					current.append(stack.pop()).append(' ');
				stack.pop();
			}
		}
		while (! stack.empty())
			current.append(stack.pop()).append(' ');
		return current.substring(0, current.length() - 1);
	}

	public static double RPNtoAnswer(String rpn) {
		Stack<Double> stack = new Stack<>();
		String[] data = rpn.split(" ");

		for (String item : data) {
			if (getPriority(item) == 0)
				stack.push(Double.parseDouble(item));
			if (getPriority(item) > 1) {
				double a = stack.pop(), b = stack.pop();

				switch (item) {
					case "+" -> stack.push(b + a);
					case "-" -> stack.push(b - a);
					case "*" -> stack.push(b * a);
					case "/" -> stack.push(b / a);
				}
			}
		}
		return stack.pop();
	}

	public static int getPriority(String token) {
		if (token.length() > 1)
			return 0;
		if (token.equals("*") || token.equals("/"))
			return 3;
		if (token.equals("+") || token.equals("-"))
			return 2;
		if (token.equals("("))
			return 1;
		if (token.equals(")"))
			return -1;
		return 0;
	}
}

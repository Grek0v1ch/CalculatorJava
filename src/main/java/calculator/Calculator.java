package calculator;

import java.util.Stack;

public class Calculator {
	public static String expressionToRPN(String exp) {
		StringBuilder current = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		int priority = 0;
		for (int i = 0; i < exp.length(); i++) {
			if (Character.isSpaceChar(exp.charAt(i)))
				continue;
			priority = getPriority(exp.charAt(i));
			if (priority == 0)
				current.append(exp.charAt(i));
			if (priority == 1)
				stack.push(exp.charAt(i));
			if (priority > 1) {
				current.append(' ');
				while (! stack.empty()) {
					if (getPriority(stack.peek()) >= priority)
						current.append(stack.pop());
					else
						break;
				}
				stack.push(exp.charAt(i));
			}
			if (priority == -1) {
				current.append(' ');
				while (getPriority(stack.peek()) != 1)
					current.append(stack.pop());
				stack.pop();
			}

		}
		current.append(' ');
		while (! stack.empty())
			current.append(stack.pop());
		return current.toString();
	}

	public static double RPNtoAnswer(String rpn) {
		StringBuilder operand = new StringBuilder();
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < rpn.length(); i++) {
			if (Character.isSpaceChar(rpn.charAt(i)))
				continue;
			if (getPriority(rpn.charAt(i)) == 0) {
				while (! Character.isSpaceChar(rpn.charAt(i)) && getPriority(rpn.charAt(i)) == 0) {
					operand.append(rpn.charAt(i++));
					if (i == rpn.length())
						break;
				}
				stack.push(Double.parseDouble(operand.toString()));
				operand = new StringBuilder();
			}
			if (getPriority(rpn.charAt(i)) > 1) {
				double a = stack.pop(), b = stack.pop();

				if (rpn.charAt(i) == '+')
					stack.push(a + b);
				if (rpn.charAt(i) == '-')
					stack.push(a - b);
				if (rpn.charAt(i) == '*')
					stack.push(a * b);
				if (rpn.charAt(i) == '/')
					stack.push(a / b);
			}
		}
		return stack.pop();
	}

	private static int getPriority(Character token) {
		if (token == '*' || token == '/')
			return 3;
		if (token == '+' || token == '-')
			return 2;
		if (token == '(')
			return 1;
		if (token == ')')
			return -1;
		return 0;
	}
}

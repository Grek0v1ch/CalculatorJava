import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
	@Test
	void testGetPriority() {
		assertEquals(3, Calculator.getPriority("*"));
		assertEquals(3, Calculator.getPriority("/"));

		assertEquals(2, Calculator.getPriority("+"));
		assertEquals(2, Calculator.getPriority("-"));

		assertEquals(-1, Calculator.getPriority(")"));
		assertEquals(1, Calculator.getPriority("("));

		assertEquals(0, Calculator.getPriority("123"));
		assertEquals(0, Calculator.getPriority("345"));
	}

	@Test
	void testExpressionToRPN() {
		String result = Calculator.expressionToRPN("2 + 2");
		assertEquals("2 2 +", result);

		result = Calculator.expressionToRPN("2 + 2 * 2");
		assertEquals("2 2 2 * +", result);

		result = Calculator.expressionToRPN("( 2 + 2 ) * 2");
		assertEquals("2 2 + 2 *", result);

		result = Calculator.expressionToRPN("( 2 + 2 * 2 ) * 2");
		assertEquals("2 2 2 * + 2 *", result);

		result = Calculator.expressionToRPN("( 24 + 12 * 2 ) * 52");
		assertEquals("24 12 2 * + 52 *", result);
	}

	@Test
	void testRPNtoAnswer() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("2 + 2"));
		assertEquals(4, answer);

		answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("2 + 2 * 2"));
		assertEquals(6, answer);

		answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("( 2 + 2 ) * 2"));
		assertEquals(8, answer);

		answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("( 2 + 2 * 2 ) * 2"));
		assertEquals(12, answer);

		answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("( 24 + 12 * 2 ) * 52"));
		assertEquals(2496, answer);

		answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("2 - 3"));
		assertEquals(-1, answer);
	}

}

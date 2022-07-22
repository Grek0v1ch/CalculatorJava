import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
	@Test
	void testExpressionToRPN() {
		String result = Calculator.expressionToRPN("2 + 2");
		assertEquals("2 2 +", result);
	}

	@Test
	void testExpressionToRPN_1() {
		String result = Calculator.expressionToRPN("2 + 2 * 2");
		assertEquals("2 2 2 *+", result);
	}

	@Test
	void testExpressionToRPN_2() {
		String result = Calculator.expressionToRPN("(2 + 2) * 2");
		assertEquals("2 2 + 2 *", result);
	}

	@Test
	void testExpressionToRPN_3() {
		String result = Calculator.expressionToRPN("(2 + 2 * 2) * 2");
		assertEquals("2 2 2 *+ 2 *", result);
	}

	@Test
	void testExpressionToRPN_4() {
		String result = Calculator.expressionToRPN("(24 + 12 * 2) * 52");
		assertEquals("24 12 2 *+ 52 *", result);
	}

	@Test
	void testRPNtoAnswer() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("2 + 2"));
		assertEquals(4, answer);
	}

	@Test
	void testRPNtoAnswer_1() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("2 + 2 * 2"));
		assertEquals(6, answer);
	}

	@Test
	void testRPNtoAnswer_2() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("(2 + 2) * 2"));
		assertEquals(8, answer);
	}

	@Test
	void testRPNtoAnswer_3() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("(2 + 2 * 2) * 2"));
		assertEquals(12, answer);
	}

	@Test
	void testRPNtoAnswer_4() {
		double answer = Calculator.RPNtoAnswer(Calculator.expressionToRPN("(24 + 12 * 2) * 52"));
		assertEquals(2496, answer);
	}
}

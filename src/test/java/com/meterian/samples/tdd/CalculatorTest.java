package com.meterian.samples.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@Before
	public void initialize() {
		calculator = new Calculator();
	}
	
	@Test
	public void shouldAddReturnZeroWhenEmptyString() {
		int sum = calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void shouldAddReturnOneWhenStringIsOne() {
		int sum = calculator.add("1");
		assertEquals(1, sum);
	}
	
	@Test
	public void shouldOnePlusTwoEqualsThree() {
		int sum = calculator.add("1,2");
		assertEquals(3, sum);
	}
	
	@Test
	public void shouldOnePlusTwoPlusThreeEqualsSix() {
		int sum = calculator.add("1,2,3");
		assertEquals(6, sum);
	}
	
	@Test
	public void shouldAllowNewlineAsDelimiter() {
		int sum = calculator.add("1\n2\n3");
		assertEquals(6, sum);
	}
	
	@Test
	public void shouldAllowUseOfCustomDelimiter() {
		int sum = calculator.add("//;\n1;2;3");
		assertEquals(6, sum);
	}
	
	@Test
	public void shouldAllowUseOfCustomDelimiters() {
		int sum = calculator.add("//;,\n1;2,3");
		assertEquals(6, sum);
	}
}

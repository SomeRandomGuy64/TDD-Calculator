package com.meterian.samples.tdd;

public class Calculator {

	public int add(String expression) {
		int[] values = extractValues(expression);
		int sum = addValues(values);
		return sum;
	}

	private int addValues(int[] values) {
		int sum = 0;
		
		for(int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}

	private int[] extractValues(String expression) {
		String customDelimiter = extractCustomDelimiter(expression);
		
		String[] stringValues;
		if (customDelimiter.isEmpty()) {
			stringValues = expression.split("[,\n]");
		} else {
			stringValues = expression.substring(4).split(customDelimiter);
		}
		
		int[] values = new int[stringValues.length];
		
		for(int i = 0; i < stringValues.length; i++) {
			values[i] = toInteger(stringValues[i]);
		}
		
		return values;
	}

	private String extractCustomDelimiter(String expression) {
		String customDelimiter;
		if(expression.length() > 3
				&& expression.charAt(0) == '/' 
				&& expression.charAt(1) == '/' 
				&& expression.charAt(3) == '\n' ) {
			customDelimiter = Character.toString(expression.charAt(2));
		} else {
			customDelimiter = "";
		}
		
		return customDelimiter;
	}

	public int toInteger(String expression) {
		int value;
		if(expression.equals("")) {
			value = 0;
		} else {
			value = Integer.parseInt(expression);
		}
		return value;
	}

}

package by.segg3r.expectunit.expectations;

import static org.junit.Assert.*;

import org.junit.Test;

import by.segg3r.expectunit.Expectation;

public class AndExpectationTest {
	
	private Expectation<Object> positive = new Expectation<Object>() {
		public boolean match(Object object) {
			return true;
		}
	};
	
	private Expectation<Object> negative = new Expectation<Object>() {
		public boolean match(Object object) {
			return false;
		}
	};
	
	@Test
	public void bothPositive() {
		Expectation<Object> and = new AndExpectation<Object>(positive, positive);
		assertTrue(and.match(new Object()));
	}
	
	@Test
	public void bothNegative() {
		Expectation<Object> and = new AndExpectation<Object>(negative, negative);
		assertFalse(and.match(new Object()));
	}
	
	@Test
	public void onePositiveOneNegative() {
		Expectation<Object> and = new AndExpectation<Object>(positive, negative);
		assertFalse(and.match(new Object()));
	}
	
}

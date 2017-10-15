package com.demo.conditions;

import org.springframework.stereotype.Component;

/** 
 *Must be between 3 and 20 characters in length.  Condition verified  using String.length
 *
 */
@Component
public class ConditionForLengthCheck implements ConditionValidator {
	private final int MIN_LENGTH = 3;
	private final int MAX_LENGTH = 20;
	
	@Override
	public boolean verfyCondition(String string) {
		return string.length() >= MIN_LENGTH && string.length() <= MAX_LENGTH;
	}
}
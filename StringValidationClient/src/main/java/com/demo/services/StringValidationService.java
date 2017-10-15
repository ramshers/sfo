package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.conditions.ConditionValidator;

@Service
public class StringValidationService implements StringValidator {
	/**
	 * This method checks if the string matches the given checks.
	 * 
	 * @param password
	 * @return true if the string passes checks,  else false.
	 */
	@Autowired
	List<ConditionValidator> listOfConditionValidators;
	
	@Override 
	public boolean validateString(String string)
	{
		boolean stringPassesChecks=true;
		for (ConditionValidator condition: listOfConditionValidators)
		{
			if(condition.verfyCondition(string)) {
				System.out.printf("%-30s - %S\n" , condition.getClass().getSimpleName(), "passed");
			} else
			{
				System.out.printf("%-30s - %S\n" , condition.getClass().getSimpleName(), "failed");
				stringPassesChecks=false;
			}
		}
		return stringPassesChecks;
	}
}

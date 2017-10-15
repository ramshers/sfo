package com.demo.tests.conditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.conditions.ConditionValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionForLengthCheckTest {

	@Autowired
	ConditionValidator condition;

	@Test
	public void testForLengthLessThanThree() {
		boolean actualRes = condition.verfyCondition("a9");
		assertThat(actualRes, is(false));
	}

	@Test
	public void testForLengthExatlyThree() {
		boolean actualRes = condition.verfyCondition("a9e");
		assertThat(actualRes, is(true));
	}
	
	@Test
	public void testForLengthExactlyTwenty() {
		boolean actualRes = condition.verfyCondition("abcdefghij1234567890");
		assertThat(actualRes, is(true));
	}

	@Test
	public void testForLengthGreaterThanTwenty() {
		boolean actualRes = condition.verfyCondition("abcdefghijklmnopqrstuv012");
		assertThat(actualRes, is(false));
	}

	@Test
	public void testForLengthBTWThreeAndTwenty() {
		boolean actualRes = condition.verfyCondition("efghjk12");
		assertThat(actualRes, is(true));
	}

}

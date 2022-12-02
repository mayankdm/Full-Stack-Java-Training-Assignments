package Day5;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VoterTest {
	@Test
	public void validateVoterAgeValidTest() throws Exception {
		int age = 19;
		Voter voter = new Voter();
		boolean result = voter.isVoterValid(age);
		Assertions.assertTrue(result);
	}

	@Test
	public void validateVoterAgeInvalidTest() throws Exception {
		int age = 10;
		Voter voterValidator = new Voter();
		boolean result = voterValidator.isVoterValid(age);
		Assertions.assertFalse(result);
	}

	@Test
	public void validateVoterAgeInvalidTest2() throws Exception {
		int age = -14;
		Voter voter = new Voter();
		Exception exception = Assertions.assertThrows(Exception.class, () -> voter.isVoterValid(age));
	}

	@ParameterizedTest
	@CsvSource(value = { "19, true", "20,true", "17,false", "16,false" })
	public void validateVoterAgeTestParameter(int age, boolean expected) throws Exception {
		Voter voter = new Voter();
		boolean actual = voter.isVoterValid(age);
		Assertions.assertEquals(expected, actual);
	}
}

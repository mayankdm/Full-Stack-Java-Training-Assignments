package training.week1;

public class Voter {
	public boolean isVoterValid(int age) throws Exception {
		if (age < 0) {
			throw new Exception("Invalid age");
		}
		return age >= 18;
	}
}

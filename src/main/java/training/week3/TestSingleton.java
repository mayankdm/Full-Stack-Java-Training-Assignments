package training.week3;

public class TestSingleton {
	private static TestSingleton testSingleton = null;

	private TestSingleton() {

	}

	public static TestSingleton getInstance() {
		if (testSingleton == null)
			testSingleton = new TestSingleton();

		return testSingleton;
	}
}

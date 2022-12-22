package training.week3;

public class TestException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestException(String value) {
		super(value);
	}

	public static void main(String[] args) {
		try {
			// Throw an object of user defined exception
			throw new TestException("GeeksGeeks");
		} catch (TestException ex) {
			System.out.println("Caught");

			// Print the message from MyException object
			System.out.println(ex.getMessage());
		}
	}
}

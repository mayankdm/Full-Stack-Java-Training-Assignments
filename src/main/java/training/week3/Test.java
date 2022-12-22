package training.week3;

public class Test {
	public static void main(String[] args) {
		TestSingleton t1 = TestSingleton.getInstance();
		TestSingleton t2 = TestSingleton.getInstance();
		TestSingleton t3 = TestSingleton.getInstance();
		
		if(t1.equals(t3) && t2.equals(t3) && t1.equals(t2)){
			System.out.println("all instances are equal!");
		}
	}
}

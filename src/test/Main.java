package test;

public class Main {
	String name;
	
	public Main(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		Main main = new Main("");
		System.out.println(main.name);
	}

	private static void print() {
		System.out.println(1);
		print();
	}
}

package week1;

public class LambdaExpression {
	public static void main(String[] args) {
		OddNumber oddNumber = (int number) -> {
			return (number % 2 == 1);
		};
		PrimeNumber primeNumber = (int number) -> {
			if (number <= 1) {
				return false;
			}
			if (number <= 3) {
				return true;
			}
			if (number % 2 == 0 || number % 3 == 0)
				return false;
			for (int i = 5; i * i <= number; i = i + 6)
				if (number % i == 0 || number % (i + 2) == 0)
					return false;

			return true;
		};
		System.out.println(oddNumber.isOdd(1));
		System.out.println(primeNumber.isPrime(7));

	}
}

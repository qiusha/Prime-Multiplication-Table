import java.util.List;
import java.util.LinkedList;

public class PrimeUtil {

	private static final String TAB = "\t";
	private int primeCount;
	private List<Integer> primes;

	public PrimeUtil(int primeCount) {
		this.primeCount = primeCount;
		this.primes = new LinkedList<Integer>();
	}

	public List<Integer> generatePrime() {
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (primes.size() == primeCount) {
				break;
			}
			if(sixKOptimization(i)) {
				primes.add(i);
			}

		}

		return primes;
	}

	private boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
		return true;
	}

	//https://en.wikipedia.org/wiki/Primality_test#Pseudocode
	private boolean sixKOptimization(int num) {
		if (num <= 1) {
			return false;
		} else if (num <= 3) {
			return true;
		} else if (num%2 == 0 || num%3 == 0) {
			return false;
		}

		int i = 5;
		while (i * i <= num) {
			if (num%i == 0 || num%(i + 2) == 0) {
				return false;
			}
			i += 6;
		}
		return true;
	}

	public void printTable(int[][] primeTable) {
		for (int i = 0; i < primes.size(); i++) {
			System.out.print(TAB + primes.get(i));
		}
		System.out.println();

		for (int i = 0; i < primeCount; i++) {
			System.out.print(primes.get(i) + TAB);
			for (int j = 0; j < primeCount; j++) {
				System.out.print(primeTable[i][j] + TAB);
			}
			System.out.println();
		}
	}
}
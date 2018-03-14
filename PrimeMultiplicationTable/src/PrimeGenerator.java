import java.util.List;
import java.util.LinkedList;

public class PrimeGenerator {
	private int primeCount;

	public PrimeGenerator(int primeCount) {
		this.primeCount = primeCount;
	}

	public List<Integer> generatePrime() {
		List<Integer> primes = new LinkedList<Integer>();
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (primes.size() == primeCount) {
				break;
			}
			if(isPrime(i)) {
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
}
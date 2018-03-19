import java.util.List;

public class PrimeMultiplicationTable {
	private int primeCount;
	private List<Integer> primes;
	private int[][] primeTable;

	public PrimeMultiplicationTable(int primeCount, List<Integer> primes) {
		this.primeCount = primeCount;
		this.primes = primes;
		this.primeTable = new int[primeCount][primeCount];
	}

	public int[][] generateTable() {
		for (int i = 0; i < primeCount; i++) {
			for (int j = i; j < primeCount; j++) {
				int mul = primes.get(i)*primes.get(j);
				primeTable[i][j] = mul;
				if (i != j) {
					primeTable[j][i] = mul;
				}
			}
		}

		return primeTable;
	}
}
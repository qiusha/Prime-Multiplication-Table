import java.util.List;

public class PrimeMultiplicationTable {
	private int primeCount;
	private List<Integer> primes;
	private int[][] primeTable;
	private static final String TAB = "\t";

	public PrimeMultiplicationTable(int primeCount, List<Integer> primes) {
		this.primeCount = primeCount;
		this.primes = primes;
		this.primeTable = new int[primeCount][primeCount];
	}

	public void generateTable() {
		for (int i = 0; i < primeCount; i++) {
			for (int j = i; j < primeCount; j++) {
				int mul = primes.get(i)*primes.get(j);
				primeTable[i][j] = mul;
				if (i != j) {
					primeTable[j][i] = mul;
				}
			}
		}
	}
	public void printTable() {
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
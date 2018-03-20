import java.lang.Runnable;
import java.util.List;
import java.lang.Thread;

public class PrimeMultiplicationTableThread implements Runnable {
	private static final String TAB = "\t";
	private static int column_number;
	private static int[][] primeTable;

	private int primeCount;
	private List<Integer> primes;

	public PrimeMultiplicationTableThread(int primeCount, List<Integer> primes) {
		this.primeCount = primeCount;
		this.primes = primes;
		this.primeTable = new int[primeCount][primeCount];
		this.column_number = 0;
	}

	public static int[][] getPrimeTable() {
		return primeTable;
	}

	// Atomic counter to indicate which column to calculate
	private static synchronized int getColumnNumber() {
		return column_number++;
	}

	// Multiply prime numbers to generate prime table
	@Override
	public void run() {
		int column;
		while((column = getColumnNumber()) < primeCount){
			for (int i = 0; i <= column; i++) {
				int product = primes.get(i)*primes.get(column);
				primeTable[i][column] = product;
				if (i != column) {
					primeTable[column][i] = product;
				}
			}
		}
	}
}
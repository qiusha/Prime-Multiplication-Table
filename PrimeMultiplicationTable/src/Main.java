import java.util.List;

public class Main {

	public static void main(String[] args) {
		int primeCount = Integer.parseInt(args[0]);
		PrimeUtil primeUtil = new PrimeUtil(primeCount);

		long start_time = System.currentTimeMillis();

		List<Integer>  primes = primeUtil.generatePrime();

		long mid_time = System.currentTimeMillis();

		System.out.println("Time of Generating primes: " + (mid_time - start_time) + " milliseconds...");

		/*PrimeMultiplicationTable primeMultiplicationTable = new PrimeMultiplicationTable(primeCount, primes);
		int[][] primeTable = primeMultiplicationTable.generateTable();

		long end_time = System.currentTimeMillis();

		primeUtil.printTable(primeTable);
		System.out.println("Time of Generating multiplication table: " + (end_time - mid_time) + " milliseconds...");*/
	}
	
}
import java.util.List;
import java.lang.NumberFormatException;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main [number of primes], exiting...");
  			System.exit(0);
		}
		int primeCount;
		try{
			primeCount = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
    		throw new NumberFormatException();
  		}

  		if (primeCount <= 0) {
  			System.out.println("Number of Prime must be larger to 0, exiting...");
  			System.exit(0);
  		}

		long start_time = System.currentTimeMillis();

		PrimeUtil primeUtil = new PrimeUtil(primeCount);
		List<Integer>  primes = primeUtil.generatePrime();

		long mid_time = System.currentTimeMillis();

		System.out.println("Time of Generating primes: " + (mid_time - start_time) + " milliseconds...");

		PrimeMultiplicationTable primeMultiplicationTable = new PrimeMultiplicationTable(primeCount, primes);
		int[][] primeTable = primeMultiplicationTable.generateTable();

		long end_time = System.currentTimeMillis();

		primeUtil.printTable(primeTable);
		System.out.println("Time of Generating multiplication table: " + (end_time - mid_time) + " milliseconds...");
	}
	
}
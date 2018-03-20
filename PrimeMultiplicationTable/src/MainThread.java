import java.util.List;
import java.lang.InterruptedException;

public class MainThread {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Main [number of primes] [number of thread], exiting...");
  			System.exit(0);
		}
		int primeCount;
		int threadCount;
		try{
			primeCount = Integer.parseInt(args[0]);
			threadCount = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
    		throw new NumberFormatException();
  		}

  		if (primeCount <= 0 || threadCount <= 0) {
  			System.out.println("Number of Prime and number of threads must be larger to 0, exiting...");
  			System.exit(0);
  		}

		long start_time = System.currentTimeMillis();

		// Generate prime numbers
		PrimeUtil primeUtil = new PrimeUtil(primeCount);
		List<Integer>  primes = primeUtil.generatePrime();

		long mid_time = System.currentTimeMillis();

		System.out.println("Time of Generating primes: " + (mid_time - start_time) + " milliseconds...");

		// Generate prime table
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			PrimeMultiplicationTableThread primeMultiplicationTableThread = new PrimeMultiplicationTableThread(primeCount, primes);
			threads[i] = new Thread(primeMultiplicationTableThread);
			threads[i].start();
		}

		for (int i = 0; i < threadCount; i++) {
			try {
				threads[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		long end_time = System.currentTimeMillis();

		// Print prime table
		primeUtil.printTable(PrimeMultiplicationTableThread.getPrimeTable());
		
		System.out.println("Time of Generating multiplication table: " + (end_time - mid_time) + " milliseconds...");
	}
	
}
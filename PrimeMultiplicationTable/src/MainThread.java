import java.util.List;
import java.lang.InterruptedException;

public class MainThread {

	public static void main(String[] args) {
		int primeCount = Integer.parseInt(args[0]);
		int threadCount = Integer.parseInt(args[1]);
		PrimeUtil primeUtil = new PrimeUtil(primeCount);
		List<Integer>  primes = primeUtil.generatePrime();

		long start_time = System.currentTimeMillis();

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

		primeUtil.printTable(PrimeMultiplicationTableThread.getPrimeTable());
		System.out.println("Time of Generating multiplication table: " + (end_time - start_time) + " milliseconds...");
	}
	
}
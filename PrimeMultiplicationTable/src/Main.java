import java.util.List;

public class Main {

	public static void main(String[] args) {
		int primeCount = Integer.parseInt(args[0]);
		PrimeGenerator primeGenerator = new PrimeGenerator(primeCount);
		List<Integer>  primes = primeGenerator.generatePrime();
		PrimeMultiplicationTable primeMultiplicationTable = new PrimeMultiplicationTable(primeCount, primes);
		primeMultiplicationTable.generateTable();
		primeMultiplicationTable.printTable();
	}
	
}
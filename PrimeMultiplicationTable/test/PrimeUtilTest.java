import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import org.apache.commons.math3.primes.Primes;

	public class PrimeUtilTest {
		PrimeUtil primeUtil;
		Random rand;

		@Before
		public void setUp() throws Exception {
			primeUtil = new PrimeUtil(10);
			rand = new Random();
		}

		@Test
		public void testGeneratePrime() {
			Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
			HashSet<Integer> hs = new HashSet<>(Arrays.asList(primes));
			List<Integer> generatePrimes = primeUtil.generatePrime();

			for (int p : generatePrimes) {
				hs.remove(p);
			}

			System.out.println("Testing first ten prime numbers");
			assertEquals(0, hs.size());
			System.out.println("Passed test ------------------------------------ generatePrime");
		}

		@Test
		public void testIsPrime() {
			for (int i = 0; i < 10; i++) {
				int testNumber = rand.nextInt(10000);
				System.out.println("Testing random prime number " + testNumber);
				assertEquals(Primes.isPrime(testNumber), primeUtil.isPrime(testNumber));
			}
			System.out.println("Passed test ------------------------------------ isPrime");
		}

		@Test
		public void testSixKOptimization() {
			for (int i = 0; i < 10; i++) {
				int testNumber = rand.nextInt(10000);
				System.out.println("Testing random prime number " + testNumber);
				assertEquals(Primes.isPrime(testNumber), primeUtil.sixKOptimization(testNumber));
			}
			System.out.println("Passed test ------------------------------------ sixKOptimization");
		}

		@Test
		public void testPrintTable() {
			int[][] table = {{4, 6, 10, 14}, {6, 9, 15, 21}, {10, 15, 25, 35}, {14, 21, 35, 49}};
			int primeCount = 4;
			List<Integer> primes = new LinkedList<>();
			primes.add(2);
			primes.add(3);
			primes.add(5);
			primes.add(7);
			PrimeMultiplicationTable primeMultiplicationTable = new PrimeMultiplicationTable(primeCount, primes);
			int[][] resultTable = primeMultiplicationTable.generateTable();

			System.out.println("Testing primeTable with prime number size = 4");
			for (int i = 0; i < primeCount; i++) {
				for (int j = 0; j < primeCount; j++) { 
					assertEquals(table[i][j], resultTable[i][j]);
				}
			}
			System.out.println("Passed test ------------------------------------ printTable");
		}
	}
jar cvfe primeTable.jar Main Main.class PrimeMultiplicationTable.class PrimeUtil.class
jar cvfe primeTableThread.jar MainThread MainThread.class PrimeMultiplicationTableThread.class PrimeUtil.class

Prime Multiplication table
primeTable.jar USAGE:
java -jar primetable.jar [number of primes]
java -jar primetable.jar 100

primeTableThread.jar USAGE:
java -jar primetableThread.jar [number of primes] [number of threads]
java -jar primetableThread.jar 100 2

ALGORITHM:
1. Naive Method of generating required number of prime numbers by checking if the number can be divided by 2...Math.sqrt(number)
2. 6K optimization [https://en.wikipedia.org/wiki/Primality_test#Pseudocode]

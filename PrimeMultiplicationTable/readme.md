## Prime Multiplication Table

### Requirement
Have JAVA runtime environment ready , then you are good to go.

### Usage
primeTable.jar
```
java -jar primeTable.jar [number of primes]
java -jar primeTable.jar 100
```
primeTableThread.jar
```
java -jar primeTableThread.jar [number of primes] [number of threads]
java -jar primeTableThread.jar 100 2
```
#### ALGORITHM:
1. Naive Method of generating required number of prime numbers by checking if the number can be divided by 2...Math.sqrt(number)
2. 6K optimization [https://en.wikipedia.org/wiki/Primality_test#Pseudocode]

### Complexity
#### Prime Detection Algorithm
The prime detection algorithm 1 and 2 runs O(\sqrt{n}) for each number while n is the total count of number being tested.
Therefore the time complexity of finding m prime numbers is O(n*\sqrt{n}) while n is the total count of number being tested.


|                  | 1000 primes      | 10,000 primes    | 100,000 primes   |
| ---------------- | ---------------- | ---------------- | ---------------- |
| Naive Method     | 2 milliseconds   | 12 milliseconds  | 289 milliseconds |
| 6K optimization  | 1 milliseconds   | 7 milliseconds   | 88 milliseconds  |

#### Multiplication table Generation
To fill in to the m\*m prime table, we need to have two for loops to loop through all the prime members. However, we don't need to calculate the value m\*m times because primeTable[i][j] = primeTable[j][i]. Therefore, the total number of multiplies are \frac{n^2+n}{2}. This result in the time complexity of generating prime multiplication table to be O(n^2);

### Scalability
This program can only support the maimum prime number to be 46,340. This is becasuse the square of 46,340 will almost reach 2^31 - 1, which is the largest integer value java can provide. If we want bigger number, we need to use long as the number type, that can support largest prime numner of 3,037,000,499.

The major bottleneck for the program lies in the O(n^2) when we want to produce the prime multiplication table.
Multi-threading can be used to utilize computer power and speed up the table generation process.

|                  | Single Thread    | 2 threads        | 4 threads        | 8 threads        |
| ---------------- | ---------------- | ---------------- | ---------------- | ---------------- |
| 100 primes       | 2 milliseconds     | 5 milliseconds     | 6 milliseconds     | 7 milliseconds    |
| 1,000 primes     | 307 milliseconds     | 165 milliseconds  | 95 milliseconds   | 85 milliseconds     |
| 10,000 primes    | 351,712 milliseconds |  177,480 milliseconds  | 89,073 milliseconds  | 51,109 milliseconds  |

Using multiple threads increase the performance a lot as you can see from the above comparison table.
However, exhausting a single computer's power is not a pratical way to do in real life.\
Setting up a Hadoop cluster, taking advance of the MapReduce functionality to split multiplications into many small tasks to be calculated by multiple computers is a more feasible way if we want to scale up the prime multiplication table to huge numbers.

### Test cases
TDD:
1. Without wrting any code, the program won't pass any test case even for the simpliest print multiplciation table for 10 prime numbers.
2. After I implemented the code, it can print the table with 10 prime numbers. However, it takes a lot of time when I try to run for a large number of prime numbers say: 10,000.
3. After implementing multi-threading, the performance increased a lot. Then I try to behave like a malicious user such as input negative number as the prime count. The program will fail.
4. Then I added validity check of input to ensure the program will run correctly.

Running the Test Cases:
```
java -cp ".:../primeTable.jar:junit-4.10.jar:commons-math3-3.6.1.jar" TestRunner
```

### Build the jar file
```
jar cvfe primeTable.jar Main Main.class PrimeMultiplicationTable.class PrimeUtil.class
jar cvfe primeTableThread.jar MainThread MainThread.class PrimeMultiplicationTableThread.class PrimeUtil.class
```

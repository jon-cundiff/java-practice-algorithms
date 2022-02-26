package com.jc;

public class MathAlgo {
    // requires non-negative number
    public double squareRoot(double num, int precision) {
        /*
            Babylonian Method
            1. make initial guess
            2. get the average of the guess and the result of num / guess
            3. if the difference of the average squared and num
                is in an acceptable range, this is the square root
            4. Otherwise, the average becomes the next guess
         */

        double guess = 1;
        double tolerance = 1;
        // move decimal left for each level of precision
        for (int i = 0; i < precision; i++) {
            tolerance /= 10;
        }

        do {
            double average = ((num / guess) + guess)/ 2;
            if (average * average - num < tolerance) {
                // Math.round rounds to integer, so dividing by tolerance shifts
                // decimal to right for the round, then multiplying moves it back
                return Math.round(average / tolerance) * tolerance;
            } else {
                guess = average;
            }
        } while (true);
    }

    public boolean isPrime(int num) {
        // Initial primes that will fail the next test
        if (num == 2 || num == 3) {
          return true;
        // This test knocks out two thirds of the sample size before starting a loop
        } else if (num < 1 || num % 2 == 0 || num % 3 == 0) {
            return false;
        } else {
            /*
                Increment loop by 6, only need to test against i and i + 2
                i + 1, i + 3, i + 4, and i + 5 represents numbers that
                are divisible by 2 or 3, therefore do not need to be tested
                in this loop.
                Highest number to be tested is square root of the number, as
                beyond that, you are testing against the pair of a previously
                tested factor.
                Ex 16 = 1 x 16, 2 x 8, 4 x 4 (square root)
                8 x 2 (8 was already accounted for by testing 2),
                16 x 1 (16 was already accounted for by testing 1)
            */
            for (int i = 5; i * i <= num; i += 6) {
                if ((num % i == 0) || (num % (i + 2) == 0)) {
                    return false;
                }
            }
        }

        return true;
    }
}

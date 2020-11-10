package net.codingartist.algo_ds.math;

import java.util.concurrent.ThreadLocalRandom;

public class MathUtils {

	private MathUtils() {
		throw new AssertionError("no instantiability");
	}
	
	public static boolean isPowerOfTwo(int n) {
		return (n & (n -1)) == 0;
	}
	
	public static boolean isPowerOfThree(int n) {
		if(n < 1) {
			return false;
		}
		while(n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}
	
	public static boolean isPowerOfFour(int n) {
		return n > 0 && ((n & (n-1)) == 0) && n % 3 == 1;
	}
	
	public static boolean isEven(int a){
	   return ( (a & 1) == 0 );
	}

	public static boolean isOdd(int a){
	   return ( (a & 1) == 1 );
	}
	
	public static boolean isInt(double value) {
		return Math.floor(value) == value;
	}
	
	public static int log2(int n) {
        return (int)(Math.log(n) / Math.log(2));
    }
	
	public static int fibonacci(int n){
		if(n < 0) {
			throw new IllegalArgumentException("Fibonacci numbers starts from 0 and 1.");
		}
		if(n == 0 || n == 1){
			return n;
		}
		int a = 0;
		int b = 1;
		for(int i=2; i<n; i++){
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
	
	public static int randomInt(int mim, int max) {
		return ThreadLocalRandom.current().nextInt(mim, max + 1);
	}
	
	public static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}
	
	public static int lcm(int a, int b) {
		//a*b = gcd * lcm
		//lcm = a*b / (gcd)
		return (a*b) / gcd(a,b);
	}
}

package main;

import java.util.Arrays;

public class Recursion {

    public static int fibonacci(int n) {
	// TODO 8.1.a) compute the n-th Fibonacci number (recursively!)
	return 0;
    }

    public static double gregoryLeibnizRecursive(int n) {
	return (n > 0 ? gregoryLeibnizRecursive(n - 1) : 0) + 4.0 / (n * 2 + 1) * (1 - 2 * (n % 2));
    }

    public static double gregoryLeibnizIterative(int n) {
	// TODO 8.1.b) implement an iterative version of the Gregory-Leibniz series
	return 0.0;
    }

    public static void main(String[] args) {

	int[] fibs = new int[20];
	for (int i = 0; i < fibs.length; i++) {
	    fibs[i] = fibonacci(i);
	}
	System.out.println("Your first 20 Fibonacci numbers:");
	System.out.println(Arrays.toString(fibs));

	System.out.println("\nApproximations of Pi (" + Math.PI + "):");
	System.out.println("Recursive: " + gregoryLeibnizRecursive(10000));
	System.out.println("Iterative: " + gregoryLeibnizIterative(10000000));
    }
}

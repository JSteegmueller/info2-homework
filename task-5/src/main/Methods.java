package main;

import java.util.Scanner;
import java.util.Arrays;

public class Methods {

    // 4.3 a) TODO implement "is_equal"
    // 4.3 b) TODO implement "reverse"
    // 4.3 c) TODO implement "is_reversed"
    // 4.3 d) TODO implement "is_prime"
    // 4.3 e) TODO implement "belongs_to_prime_twin"


    public static boolean isEqual(int[] a1, int[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++)
            if (a1[i] != a2[i]) return false;
        return true;
    }

    public static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int safe = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = safe;
        }
    }

    public static boolean isReversed(int[] a, int[] b) {
        reverse(b);
        return isEqual(a, b);
    }

    public static boolean isPrime(int i) {
        if (i < 2) return false;
        for (int j = 2; j < i; j++)
            if (i % j == 0) return false;
        return true;
    }

    public static boolean belongsToPrimeTwin(int i) {
        return (isPrime(i) && (isPrime(i-2) || isPrime(i+2)));
    }


    public static void main(String[] args) {
        // task 4.1 a)
        //   System.out.println(Arrays.toString(array)) might be helpful to debug your code
        int[] a = {1, 2, 3, 4, 9};
        int[] b = {1, 2, 3, 4, 5, 6};
        int[] c = {1, 2, 3, 4, 5, 6};

        System.out.println(isEqual(a, b));

        // task 4.1 b)
        reverse(b);
        for (int x : b
        ) {
            System.out.println(x);
        }
        // task 4.1 c)
        System.out.println(isReversed(b, c));

        // task 4.1 d)
        System.out.println(isPrime(13));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(1));


        // task 4.1 e)
        System.out.println(belongsToPrimeTwin(10));
        System.out.println(belongsToPrimeTwin(11));
        System.out.println(belongsToPrimeTwin(13));
        System.out.println(belongsToPrimeTwin(23));

    }
}

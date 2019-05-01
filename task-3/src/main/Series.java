package main;

public class Series {
    // Exercise Task
    // 2.1 a)
    public static int sum_up() {
        int result = 0;

        while(result < 100) result++;

        return result;
    }

    // Exercise Task
    // 2.1 b)
    public static void multiplication_table(int n) {
        int j = 1;
        while(j <= 10){
            System.out.println(j*n);
            j++;
        }
        System.out.println();
    }

    // Exercise Task
    // 2.1 c)
    public static void fizz_buzz() {
        int i = 1;

        while ( i <= 100){
            if(i % 15 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
            i++;
        }
    }

    // Exercise Task
    // 2.1 d)
    public static void chess_board(int n) {
        for (int i = 1 ; i <= 4 ; i++ ){
            for (int j = 1 ; j <= 4 ; j++){
                System.out.print((i % 2 == 0)? "-#" : "#-");
            }
            System.out.println();
        }
    }

    // Exercise Task
    // 2.1 e)
    public static int factorial(int n) {
        int akk = 1;
        for (int i = 1 ; i <= n ; i++){
            akk *= i;
        }
        return akk;
    }

    // Exercise Task
    // 2.1 f)
    public static double ln2(int n) {
        double result = 0;
        for (int i = 1 ; i <= 100000 ; i++){
            result = result + (Math.pow(-1, i+1)/i);
        }
        return result;
    }

    // Exercise Task
    // 2.1 g)
    public static void reverse_digits(int n) {
        while (n > 0){
            System.out.print(n%10);
            n = n / 10;
        }
        System.out.println();
    }

    // Exercise Task
    // 2.1 h)
    public static double leibniz_series(int n) {
        double res = 0;

        for (int i = 0 ; i < Math.pow(10,6) ; i++){
            res += (Math.pow(-1,i) / (2*i+1) );
        }

        return res*4;
    }

    // Exercise Task
    // 2.1 i)
    public static boolean palindrome(String str) {
        int len = str.length();
        for(int j = 0 ; j < len ; j++){
            char c = str.charAt(j);
            char d = str.charAt(len - j - 1);
            if (!(c == d) )return false;
        }
        return true;
    }

    // Exercise Task
    // 2.1 j)
    public static long max_collatz(long m) {
        long max_startwert = 1;
        for (int i = 1 ; i < m ; i++ ){
            double an = i;
            int count = 0;
            while (an != 1){
                if (an % 2 == 0) an = an/2;
                else an = 3*an + 1;
                count++;
            }
            max_startwert = (count > max_startwert)? i : max_startwert ;
        }
        return max_startwert;
    }

    // Exercise Task
    // 2.1 k)
    public static double gradient_descent(double x0, double a, double b) {

        double x_cur = x0;
        double x_old = x0 + 1;
        int i = 1;
        while (Math.abs(x_cur - x_old) > Math.pow(10,-7) && !(i > 10000) ){
            x_old = x_cur;
            x_cur = x_old - (0.001 * (2*(x_old - a)));
            i++;
        }
        return Math.pow((x_cur - a), 2) + b;
    }

    // Exercise Task
    // 2.1 l)
    public static void pattern_a(int num_rows) {
        for (int i = 1; i <= num_rows ; i++){
            int j = 0;
            while (j < i){
                System.out.print(i);
                j++;
            }
            System.out.println();
        }
    }

    // Exercise Task
    // 2.1 m)
    public static void pattern_b(int num_rows) {
        for (int i = 1; i <= num_rows ; i++){
            int j = i;
            while (j > 0){
                System.out.print(j);
                j--;
            }
            System.out.println();
        }
    }

    // Exercise Task
    // 2.1 n)
    public static int seven_sum(int num) {
        int sum = 0;
        double sevens = 0;
        for (int i = 0 ; i < num ; i++){
            sevens = (sevens + 7*Math.pow(10,i));
            sum = (int) (sum + sevens);
        }
        return sum;
    }

    // Exercise Task
    // 2.1 o)
    public static void ones_and_zeros(int rows) {
        for (int i = 1; i <= rows ; i++){
            int j = 0;
            while (j < i){
                System.out.print((i % 2 == 0)?
                        (j % 2 == 0)? 1 + "," : 0 + ",":
                        (j % 2 == 0)? 0 + "," : 1 + ",");
                j++;
            }
            System.out.println();
        }
    }

    // Exercise Task
    // 2.2 p)
    public static boolean is_perfect(int number) {
        int sum = 0;
        for (int i = 1; i < number ; i++){
            if (6 % i == 0) sum += i;
        }
        return sum == number;
    }

    public static void main(String[] args) {

        System.out.println("2.1 a) ");
        System.out.println(sum_up());

        System.out.println("2.1 b) ");
        multiplication_table(4);

        System.out.println("2.1 c) ");
        fizz_buzz();

        System.out.println("2.1 d) ");
        chess_board(4);

        System.out.println("2.1 e) ");
        System.out.println(factorial(4));

        System.out.println("2.1 f) ");
        System.out.println(ln2(100000));

        System.out.println("2.1 g) ");
        reverse_digits(1239);

        System.out.println("2.1 h) ");
        System.out.println(leibniz_series(1000));

        System.out.println("2.1 i) ");
        System.out.println(palindrome("1"));
        System.out.println(palindrome("12321"));
        System.out.println(palindrome("12323"));

        System.out.println("2.1 j) ");
        System.out.println(max_collatz(100));

        System.out.println("2.1 k) ");
        System.out.println(gradient_descent(1, 10, 2));

        System.out.println("2.1 l) ");
        pattern_a(5);

        System.out.println("2.1 m) ");
        pattern_b(5);

        System.out.println("2.1 n) ");
        System.out.println(seven_sum(1)); // 7 = 7
        System.out.println(seven_sum(2)); // 7 + 77 = 84
        System.out.println(seven_sum(3)); // 7 + 77 + 777 = 861

        System.out.println("2.1 o) ");
        ones_and_zeros(4);

        System.out.println("2.1 p) ");
        System.out.println(is_perfect(6));
        System.out.println(is_perfect(14));
    }
}

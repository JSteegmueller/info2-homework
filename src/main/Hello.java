package main;

public class Hello {

    public static void main(String[] args) {

        System.out.println("Ihren Namen");
        System.out.println("40 + 2= " + plus(40,2));
    }

    private static int plus(int num1, int num2){
        return num1 + num2;
    }
}

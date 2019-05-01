package main;

import java.util.Scanner;

public class Imprecision {
    // Exercise Task
    // 2.2 a)
    public static float different_same_sum(float x){

        float forward_sum = 0;
        float backward_sum = 0;

        for(int i = 1 ; i <= 100 ; i++){
            forward_sum += ( (Math.pow(-1,i+1) / i) * Math.pow(x-1, i) );
            backward_sum +=  ( (Math.pow(-1,(100 - i)+1) / (100 - i)) * Math.pow(x-1, (100 - i)) );
        }

        return forward_sum - backward_sum;
    }

    // Exercise Task
    // 2.2 b)
    public static double double_eval_polynom(double x0, double y0){
        double res = 0;

        res = 333.75 * Math.pow(y0,6) + Math.pow(x0, 2) * (11 * Math.pow(x0, 2) * Math.pow(y0, 2) - Math.pow(y0,6) - 121 * Math.pow(y0,4) -2) + 5.5 * Math.pow(y0,8) + x0/(2*y0);
        return res;
    }

    // Exercise Task
    // 2.2 b)  Part 2
    public static float float_eval_polynom(float x0, float y0){
        float res = 0;

        res = 333.75f * (float)Math.pow(y0,6) + (float)Math.pow(x0, 2) * (11f * (float)Math.pow(x0, 2) * (float)Math.pow(y0, 2) - (float)Math.pow(y0,6) - 121f * (float)Math.pow(y0,4) - 2f) + 5.5f * (float)Math.pow(y0,8) + x0/(2f*y0);


        return res;
    }




    public static void main(String[] args) {
        System.out.println("2.2 a) ");
        System.out.println(different_same_sum(2.97f));
        System.out.println("2.2 b) ");
        System.out.println(double_eval_polynom(77617, 33096));
        System.out.println(float_eval_polynom(77617, 33096));

    }
}

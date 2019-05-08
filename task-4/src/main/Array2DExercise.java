package main;

import java.util.Scanner;

public class Array2DExercise {
  // 3.2 a)
  public static void print_array_2d(int[] array) {
    // TODO fill me

  }


  // 3.2 b)
  public static int[] walk(int[] labyrinth) {

    // TODO fill me
    // you should change the labyrinth variable

    return labyrinth;
  }


  public static void main(String[] args) {
    {
      int[] array = new int[5 * 5];
      array[0 * 5 + 2] = 8;
      array[2 * 5 + 1] = 8;
      print_array_2d(array);
      System.out.print("\n");
      print_array_2d(walk(array));
    }
    System.out.print("\n\n--------------------\n\n");
    {
      int[] array = new int[5 * 5];
      array[0 * 5 + 2] = 8;
      array[2 * 5 + 1] = 8;
      array[1 * 5 + 3] = 8;
      array[4 * 5 + 2] = 8;
      array[3 * 5 + 4] = 8;
      print_array_2d(array);
      System.out.print("\n");
      print_array_2d(walk(array));
    }
    System.out.print("\n\n--------------------\n\n");



  }
}

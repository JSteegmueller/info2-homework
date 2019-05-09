package main;

import java.util.Scanner;

public class Array2DExercise {
  // 3.2 a)
  public static void print_array_2d(int[] array) {
    int size = (int)Math.sqrt(array.length);
    for(int i = 0 ; i < array.length ; i++)
      System.out.print((i%size == 0)?"\n"+array[i]:array[i]);
  }


  // 3.2 b)
  public static int[] walk(int[] labyrinth) {
    // you should change the labyrinth variable
    int size = (int)Math.sqrt(labyrinth.length), moved = 0;
    int i = 0;
    boolean end = false;
    while(true){
      if(labyrinth[i] != 8){
        labyrinth[i] = 1;
        i++;
        if(i%size==0) break;
      } else {
        i = i+size-1;
      }
    }
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

package main;


public class Array1DExercise {


  public static void print_array(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      System.out.print(" ");
    }
  }
  public static void print_array(double[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      System.out.print(" ");
    }
  }


  // 3.2 a)
  public static int find_with_for(int[] haystack, int needle) {
  int pos;
    for (pos = 0;  pos < haystack.length ; pos++)
      if (haystack[pos] == needle) return pos;
    return pos;
  }

  // 3.2 b)
  public static int find_with_while(int[] haystack, int needle) {
    int pos = 0;
    while(pos < haystack.length)
      if(haystack[pos] == needle) return pos;
      else pos++;
    return pos;
  }

  // compute average
  // 3.2 c)
  public static double average(int[] array) {
    double avg = 0;
    for (int i: array)
      avg += i;
    return avg/array.length;
  }


  // sum up only negative numbers
  // 3.2 d)
  public static int sum_negative(int[] array) {
    int sum = 0;
    for(int i:array)
      if (i < 0) sum +=i;
    return sum;
  }


  // average of only negative numbers
  // 3.2 e)
  public static double average_negative(int[] array) {
    double avg = 0;
    int num_n = 0;
    for (int i: array) {
      if (i < 0){
        avg += i;
        num_n++;
      }
    }
    return (num_n == 0)? 0 : avg/num_n;
  }

  // 3.2 f)
  public static void shift_by_one_to_right(int[] array) {
    // shift array to right. Any change here will affect the parameter "array"
    // {0, 1, 2, 3, 4, 5, 6} --> {6, 0, 1, 2, 3, 4, 5}
  }

   // 3.2 g)
  public static void shift_by_one_to_left(int[] array) {
    // shift array to left. Any change here will affect the parameter "array"
    // {0, 1, 2, 3, 4, 5, 6} --> {1, 2, 3, 4, 5, 6, 0}

    // TODO: fill me

  }




  // 3.2 h)
  public static void shift_by_n_to_right(int[] array, int n) {
    // {0, 1, 2, 3, 4, 5, 6} (n=2) --> {5, 6, 0, 1, 2, 3, 4}

    // TODO: fill me
  }



  // 3.2 i)
  public static int[] concat_arrays(int[] array1, int[] array2) {
    // {0, 1, 2, 3}, {4, 5, 6} -> {0, 1, 2, 3, 4, 5, 6}
    // TODO: fill change me
    int combined_length = 0;
    int[] merged = new int[combined_length];

    // TODO: fill me

    return merged;
  }

  // interleave arrays
  // 3.2 j)
  public static int[] interleave_arrays(int[] array1, int[] array2) {
    // {0, 1, 2, 3}, {4, 5, 6, 7} -> {0, 4, 1, 5, 2, 6, 3, 7}
    // TODO: fill change me
    int combined_length = 0;
    int[] result = new int[combined_length];

    // TODO: fill me

    return result;
  }


  // 3.2 k)
  public static int[] evenodd(int[] array) {
    // {3, 2, 1, 4} --> {2, 4, 3, 1}
    int[] result = new int[array.length];

    // TODO: fill me

    return result;
  }

  // 3.2 l)
  public static int[] histogram_int(int[] data, int num_bins, int bin_width) {
    int[] hist = new int[num_bins];

    // TODO: fill me

    return hist;
  }


  // 3.2 m)
  public static double second_smallest(double[] array) {
    double second_smallest = 0;

    // TODO: fill me

    return second_smallest;
  }


  public static void main(String[] args) {

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 a)");
    {
      int[] haystack = {10, 20, 30};
      int needle = 30;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_for(haystack, needle));
    }
    {
      int[] haystack = {10, 20, 30};
      int needle = 20;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_for(haystack, needle));
    }
    {
      int[] haystack = {10, 20, 30};
      int needle = 40;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_for(haystack, needle));
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 b)");
    {
      int[] haystack = {10, 20, 30};
      int needle = 30;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_while(haystack, needle));
    }
    {
      int[] haystack = {10, 20, 30};
      int needle = 20;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_while(haystack, needle));
    }
    {
      int[] haystack = {10, 20, 30};
      int needle = 40;
      System.out.printf("Found element %d in array    ", needle);
      print_array(haystack);
      System.out.printf("    on position %d \n", find_with_while(haystack, needle));
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 c)");
    {
      int[] array = {1,2,3,4};
      System.out.print("The average of elements    ");
      print_array(array);
      System.out.printf("      is     %f \n", average(array));
    }
    {
      int[] array = {4,0,-4,-5};
      System.out.print("The average of elements    ");
      print_array(array);
      System.out.printf("      is     %f \n", average(array));
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 d)");
    {
      int[] array = {1,2,3,4};
      System.out.print("The sum of negative elements in    ");
      print_array(array);
      System.out.printf("      is     %d \n", sum_negative(array));
    }
    {
      int[] array = {4,0,-4,-5};
      System.out.print("The sum of negative elements in    ");
      print_array(array);
      System.out.printf("      is     %d \n", sum_negative(array));
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 e)");
    {
      int[] array = {1,2,3,4};
      System.out.print("The average of negative elements in    ");
      print_array(array);
      System.out.printf("      is     %f \n", average_negative(array));
    }
    {
      int[] array = {4,0,-4,-5};
      System.out.print("The average of negative elements in    ");
      print_array(array);
      System.out.printf("      is     %f \n", average_negative(array));
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 f)");
    {
      int[] array = {0,1,2,3,4,5,6};
      System.out.print("shifting    ");
      print_array(array);
      System.out.print("   by 1 to right gives    ");
      shift_by_one_to_right(array);
      print_array(array);
      System.out.print("\n");
    }
    {
      int[] array = {0,1,2,3,4,5,6,7,8};
      System.out.print("shifting    ");
      print_array(array);
      System.out.print("   by 1 to right gives    ");
      shift_by_one_to_right(array);
      print_array(array);
      System.out.print("\n");
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 g)");
    {
      int[] array = {0,1,2,3,4,5,6};
      System.out.print("shifting    ");
      print_array(array);
      System.out.print("   by 1 to left gives    ");
      shift_by_one_to_left(array);
      print_array(array);
      System.out.print("\n");
    }
    {
      int[] array = {0,1,2,3,4,5,6,7,8};
      System.out.print("shifting    ");
      print_array(array);
      System.out.print("   by 1 to left gives    ");
      shift_by_one_to_left(array);
      print_array(array);
      System.out.print("\n");
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 h)");
    for (int amount = 0; amount < 4; amount++) {
      int[] array = {0, 1, 2, 3, 4, 5, 6};

      System.out.print("shifting    ");
      print_array(array);
      System.out.printf("   by %d to right gives    ", amount);
      shift_by_n_to_right(array, amount);
      print_array(array);
      System.out.print("\n");
    }


    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 i)");
    {
      int[] array1 = {0, 1, 2, 3};
      int[] array2 = {4, 5, 6};


      System.out.print("concatenating arrays  ");
      print_array(array1);
      System.out.print(" and ");
      print_array(array2);
      System.out.print(" gives ");
      print_array(concat_arrays(array1, array2));
      System.out.print("\n");
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 j)");
    {
      int[] array1 = {0, 1, 2, 3};
      int[] array2 = {4, 5, 6, 7};


      System.out.print("interleaving arrays  ");
      print_array(array1);
      System.out.print(" and ");
      print_array(array2);
      System.out.print(" gives ");
      print_array(interleave_arrays(array1, array2));
      System.out.print("\n");
    }


    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 k)");
    {
      int[] array = {3, 2, 1, 4};

      System.out.print("evenodd  takes ");
      print_array(array);
      System.out.print(" and gives   ");
      print_array(evenodd(array));
      System.out.print("\n");
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 l)");
    {
      int[] array = {15,  2,  3, 13, 17, 16,  7,  4, 13,  9,  7,  1, 16,  9,  3, 18, 16,
        6, 14, 13, 10,  2,  8, 15, 11, 18,  7,  3, 11, 17,  1, 10,  8,  3,
       18, 16, 18, 15, 11, 11,  6, 17, 18, 10, 17, 15,  1, 17, 18,  8};
      int num_bins = 7;
      int bin_width = 3;
      System.out.print("computing the histogram of \n      ");
      print_array(array);
      System.out.printf("\nwith  %d bins of width %d  gives: \n", num_bins, bin_width);

      int[] histogram = histogram_int(array, num_bins, bin_width);

      for (int i=0; i < num_bins; i++) {
        System.out.printf("bin %3d  [%3d, %3d): ", i, i*bin_width, (i+1)*bin_width);
        for (int j=0; j<histogram[i]; j++) {
          System.out.print("*");
        }
      System.out.print("\n");
      }
    }

    // -------------------------------------------------------------------------
    System.out.println("\n\n3.2 m)");
    {
      double[] array = {0.0, 1.0, 2.0};
      System.out.print("the second smallest entry of   ");
      print_array(array);
      System.out.printf(" is  %f \n", second_smallest(array));
    }
    {
      double[] array = {-4.0,-3.0,-2.0,-1.0,0.0,1.0,2.0,3.0,4.0,5.0};
      System.out.print("the second smallest entry of   ");
      print_array(array);
      System.out.printf(" is  %f \n", second_smallest(array));
      System.out.printf("\n");
    }

  }
}

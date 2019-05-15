package main;

public class IsingModel {
  // pruefen ob eine Belegung des Schachbrettes gueltig ist
  public static boolean isValid(boolean[] board, int n) {
    // this might be true or false
    return true;
  }

  public static void main(String[] args) {
    boolean[] example1 = {
      false, false, false,
      false, true, true,
      true, false, false
    };

    boolean[] example2 = {
      true, false, true,
      false, true, false,
      true, false, false
    };

    System.out.println(isValid(example1, 3));
    System.out.println(isValid(example2, 3));
  }
}

package main;

public class IsingModel {
  // pruefen ob eine Belegung des Schachbrettes gueltig ist
  public static boolean isValid(boolean[] board, int n) {
    // this might be true or false
    for (int i = 0 ; i < board.length ; i++){
      if ((i+1)%n != 0){
        if (board[i] && board[i+1]) return false;
      }
      if (i < n*(n-1)){
        if (board[i] && board[i + n]) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    boolean[] example1 = {
      false, false, false,
      false, true, true,
      true, false, false
    };

    boolean[] example2 = {
      false, true, true,
      true, false, false,
      false, false, false
    };

    System.out.println(isValid(example1, 3));
    System.out.println(isValid(example2, 3));
  }
}

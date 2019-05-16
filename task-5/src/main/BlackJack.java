package main;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BlackJack {

  public static void main(String[] args){

    System.out.println(updateMoney(0,1,"player"));
    //Das Spiel soll mit dem Aufruf der Funktion startGame(int startMoney) gestartet werden.
    startGame(1000);

  }

  public static void startGame(int startMoney){
    System.out.println("Welcome to BlackJack");

    int currentBalance = startMoney;
    String winner;
    Scanner in = new Scanner(System.in);
    int bet;

    while (true) {

      int cardValuePlayer = 0;
      int cardValueBank = 0;
      boolean bankNeedsToPlay = true;

      System.out.println(currentBalance + " ham mer :D");
      System.out.println("Wie viel hau ma aufn Putz?");

      while (true) {
        bet = in.nextInt();
        if (validBetPlayer(currentBalance, bet) == 1) break;
        System.out.println("Ungültige Eingabe!");
      }

      currentBalance = currentBalance - bet;

      System.out.println("Spieler: ");

      while (oneMoreCard()) {
        cardValuePlayer += giveCard();
        System.out.println("Aktueller Kartenwert: " + cardValuePlayer);

        if (cardValuePlayer == 21) {
          bankNeedsToPlay = false;
          break;
        } else if (cardValuePlayer > 21) {
          bankNeedsToPlay = false;
          break;
        }
      }

      System.out.println("Bank: ");

      while (cardValueBank <= 17 && bankNeedsToPlay) {
        cardValueBank += giveCard();

        if (cardValueBank > 21) {
          break;
        }
      }

      winner = evaluateWinner(cardValuePlayer, cardValueBank);

      System.out.println("Finaler Kartenwert Bank: " + cardValueBank);
      System.out.println("Finaler Kartenwert Spieler: " + cardValuePlayer);

      currentBalance = updateMoney(currentBalance, bet, winner);

      System.out.println(winner + " hat gewonnen! Konto: " + currentBalance);
      System.out.println("Weiter ? :3");

      if (in.next().toLowerCase().equals("nein") || currentBalance < 1) break;
    }
  }


  public static String evaluateWinner(int cardValuePlayer, int cardValueBank) {
    if (cardValueBank == 0 && cardValuePlayer == 21) return "player";
    else if (cardValueBank == 0 && cardValuePlayer > 21) return "bank";
    else if (cardValueBank > 21) return "player";
    else if (cardValuePlayer == cardValueBank) return "both";
    else return (cardValueBank > cardValuePlayer)? "bank" : "player";
  }

  public static int updateMoney(int currentBalance, int bet, String winner) {
    if (winner.equals("both")) return currentBalance + bet;
    else return (winner.equals("player"))?currentBalance + 2*bet : currentBalance;
  }

  public static int validBetPlayer(int currentBalance, int bet){
    return (bet <= currentBalance && bet > 0)? 1 : -1 ;
  }

  public static int giveCard(){
    return ThreadLocalRandom.current().nextInt(1,12);
  }

  public static boolean oneMoreCard(){
    Scanner s = new Scanner(System.in);

    System.out.println("Ne Karte? :3");
    System.out.println("ja/nein?");

    String in;
    while (true){
      in = s.next();
      if (in.toLowerCase().matches("nein") || in.toLowerCase().matches("ja")) return in.toLowerCase().matches("ja");
      System.out.println("Schon schwer Ja/Nein zu schreiben :3");
    }
  }


}

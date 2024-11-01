package codeSoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    private final String userName;
    Scanner scan = new Scanner(System.in);

    public NumberGame(String userName){
        this.userName = userName;
    }

    public int randomNumber(){
        Random rand = new Random();
        return rand.nextInt(1,100);
    }

    public void startGame(){
        int num = randomNumber();
        int attemps = 10;

        System.out.print("Guess: ");
        int userInput = scan.nextInt();

        while(true){
            if(userInput == num || attemps == 0){
                check(attemps, num);
                return;
            } else if (userInput < num) {
                System.out.println("\nYour Guess less than the number");
                System.out.println(attemps + " Attempts left");
                System.out.print("Guess Again: ");
                userInput = scan.nextInt();
            } else {
                System.out.println("\nYour Guess Greater than the number");
                System.out.println(attemps + " Attempts left");
                System.out.print("Guess Again: ");
                userInput = scan.nextInt();
            }
            attemps--;
        }
    }

    public void check(int attempts, int num){
        int accuracy = attempts * 10;

        if(attempts == 0){
            System.out.println("\nUnfortunately " + userName + " You lose!");
            System.out.println("Number was: " + num);
        } else {
            System.out.println("\nCongratulations " + userName + " You Won The Game");
            System.out.println("Accuracy: " + accuracy + "%");
        }
    }
}

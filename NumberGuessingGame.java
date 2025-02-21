import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        System.out.println("\uD83C\uDFAF Welcome to the Number Guessing Game!");
        System.out.println("Enter teh Lower Bound : ");
        int lower= sc.nextInt();
        System.out.println("Enter teh Upper Bound : ");
        int upper= sc.nextInt();
        int skyKey= random.nextInt(upper-lower+1)+lower;
        int count=0;
        int guess;

        System.out.println("Guess Number between "+lower+" and "+upper);

        while(true){
            System.out.println("Enter your Guess Number ");
            guess= sc.nextInt();
            count++;
            if(guess<skyKey){
                System.out.println("\uD83D\uDD3C Too low! Try again.");
            }else if(guess>skyKey){
                System.out.println("\uD83D\uDD3D Too high! Try again.");
            }
            else{
                System.out.println("\uD83C\uDF89 Congratulations! You guessed it in " + count + " attempts.");
                break;
            }

        }
        sc.close();

    }
}

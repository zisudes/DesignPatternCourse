package W_3.template_method;

import java.util.Random;
import java.util.Scanner;

public class DiceGamePlayer {
    private final String name;
    private int score;

    public DiceGamePlayer(String name){
        System.out.println("Player \"" + name + "\" has joined the Dice Game!");
        this.name = name;
        this.score = 0;
    }

    public void roll(int max){
        System.out.println("Hello " + name + "! Press enter to roll the dice.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Random r = new Random();
        int roll = (r.nextInt(max) + 1);
        System.out.println("You rolled a " + roll + "!");
        this.score += roll;
        displayScore();
    }

    public void displayScore(){
        System.out.println("Your current total score is " + this.score);
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}

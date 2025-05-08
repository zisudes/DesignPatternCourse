package W_3.state;

import java.util.Random;
import java.util.Scanner;

public class Character {
    String name;
    int hp;
    int exp;
    State level;
    boolean gameEnded;
    int dayCount;

    public Character(String name) {
        this.name = name;
        this.hp = 100;
        this.exp = 0;
        this.dayCount = 0;
        this.level = new NoviceState(this);
        this.gameEnded = false;
    }

    public void setState(State state){
        this.level = state;
    }

    public State getState(){
        return this.level;
    }

    public String getName(){
        return this.name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getInput(String[] options) {
        System.out.println("Choose what " + getName() + " will do today!");
        for (int i = 1; i <= options.length; i++) {
            System.out.printf("[%s] %s\n", i, options[i - 1]);
        }

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printStatus(){
        System.out.printf("[DAY #%s] Status of %s, the %s: %s/100 HP || %s EXP \n", getDayCount(), getName(), getState().toString(), getHp(), getExp());
    }

    public void train(){
        int amount = new Random().nextInt(20) + 10;
        System.out.printf("Training!! Gained %s EXP\n", amount);
        this.setExp(this.getExp() + amount);
    }

    public void meditate(){
        if (this.getHp() == 100){
            System.out.println("Meditating with full HP has given you some time to reflect. Gained 5 EXP");
            this.setExp(this.getExp() + 5);
            return;
        }

        int amount = new Random().nextInt(25) + 10;
        if (amount >= 100 - this.getHp()) {
            this.setHp(100);
        } else {
            this.setHp(this.getHp() + amount);
        }

        System.out.printf("Meditating!! Gained %s HP\n", amount);
    }

    public void fight(){
        int amount = new Random().nextInt(20) + 10;
        System.out.printf("Took a hit in the fight. Lost %s HP\n", amount);

        if (this.getHp() - amount < 1) {
            this.die();
        } else {
            this.setHp(this.getHp() - amount);
            int expAmount = new Random().nextInt(25) + 25;
            System.out.printf("Won the fight!! Gained %s EXP\n", expAmount);
            this.setExp(this.getExp() + expAmount);
        }
    }

    public void play(){
        while (!this.gameEnded) {
            dayCount++;
            getState().action();
        }
    }

    public int getDayCount(){
        return dayCount;
    }

    public void quit(){
        System.out.println("Thank you for playing!");
        this.gameEnded = true;
    }

    public void die(){
        System.out.println("You have died. GAME OVER!");
        this.gameEnded = true;
    }
}

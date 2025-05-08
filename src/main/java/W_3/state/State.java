package W_3.state;

import java.util.Scanner;

public abstract class State {
    private final Character character;

    public State(Character c){
        this.character = c;
    }

    public Character getCharacter(){
        return character;
    }

    public void enterPrompt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to proceed.");
        sc.nextLine();
    }

    public abstract void action();
    public abstract String toString();
}

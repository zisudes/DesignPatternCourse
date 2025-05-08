package W_3.state;

public class NoviceState extends State {
    public NoviceState(Character c) {
        super(c);
    }

    @Override
    public void action(){
        Character c = getCharacter();
        c.printStatus();
        String[] options = {"Train", "Quit"};

        int choice = c.getInput(options);

        switch (choice){
            case 1:
                c.train();
                if (c.getExp() >= 50){
                    System.out.printf("\n%s/50 EXP! CONGRATULATIONS! Advancing to the Intermediate Level!\n", c.getExp());
                    enterPrompt();
                    c.setState(new IntermediateState(c));
                }
                break;
            case 2:
                c.quit();
                break;
        }
    }

    @Override
    public String toString() {
        return "Novice";
    }
}

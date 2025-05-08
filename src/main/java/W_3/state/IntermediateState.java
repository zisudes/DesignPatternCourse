package W_3.state;

public class IntermediateState extends State {
    public IntermediateState(Character c) {
        super(c);
    }

    @Override
    public void action() {
        Character c = getCharacter();
        c.printStatus();

        String[] options = {"Train", "Meditate", "Quit"};
        int choice = c.getInput(options);

        switch (choice){
            case 1:
                c.train();
                if (c.getExp() > 100){
                    System.out.printf("%s/100 EXP! CONGRATULATIONS! Advancing to the Expert Level!\n", c.getExp());
                    c.setState(new ExpertState(c));
                    enterPrompt();
                }
                break;
            case 2:
                c.meditate();
                break;
            case 3:
                c.quit();
                break;
        }
    }

    @Override
    public String toString() {
        return "Intermediate";
    }
}

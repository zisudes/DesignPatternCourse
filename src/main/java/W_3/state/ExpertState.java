package W_3.state;

public class ExpertState extends State {
    public ExpertState(Character c) {
        super(c);
    }

    @Override
    public void action() {
        Character c = getCharacter();
        c.printStatus();

        String[] options = {"Train", "Meditate", "Fight", "Quit"};
        int choice = c.getInput(options);

        switch (choice) {
            case 1:
                c.train();
                break;
            case 2:
                c.meditate();
                break;
            case 3:
                c.fight();
                break;
            case 4:
                c.quit();
                break;
        }

        if (c.getExp() > 500){
            System.out.printf("\n%s/500 EXP! CONGRATULATIONS!\n", c.getExp());
            c.setState(new MasterState(c));
        }
    }

    @Override
    public String toString() {
        return "Expert";
    }
}

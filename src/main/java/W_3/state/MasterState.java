package W_3.state;

public class MasterState extends State {
    public MasterState(Character c) {
        super(c);
    }

    @Override
    public void action() {
        Character c = getCharacter();

        System.out.printf("On day %s of the journey, %s has reached the Master Level!\n", c.getDayCount() - 1, c.getName());

        enterPrompt();
        c.quit();
    }

    @Override
    public String toString() {
        return "Master";
    }
}

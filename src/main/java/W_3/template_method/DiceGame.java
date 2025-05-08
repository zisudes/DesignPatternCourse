package W_3.template_method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame extends Game {
    private List<DiceGamePlayer> playerList;
    private int dice;
    private boolean winConditionFulfilled = false;
    private int scoreNeeded;

    public DiceGame(){
        playerList = new ArrayList<>();
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player #" + (i + 1) + ", please enter your name: ");
            String name = sc.nextLine();
            this.playerList.add(new DiceGamePlayer(name));
        }

        System.out.println("GAME START!");
        String[] options = {"Continue with defaults", "Adjust Settings"};
        int choice = ScannerReader.promptChoice("By default, the game is played with a d6 and the score needed is 25. Adjust settings?", options);
        if (choice == 1) {
            this.dice = 6;
            this.scoreNeeded = 25;
        } else {
            System.out.println("Adjusting Settings...");
            this.dice = ScannerReader.promptInt("Enter the size of dice you would like to play with: ");
            this.scoreNeeded = ScannerReader.promptInt("Enter the score that is required to win: ");
        }
    }

    public int getDice(){
        return this.dice;
    }

    @Override
    public boolean endOfGame() {
        return winConditionFulfilled;
    }

    @Override
    public void playSingleTurn(int playerId) {
        DiceGamePlayer player = playerList.get(playerId);
        player.roll(getDice());
        if (player.getScore() > this.scoreNeeded){
            System.out.println(player.getName() + " scored over " + this.scoreNeeded + ", and won the game!");
            System.out.println("Press enter to display the scoreboard");
            new Scanner(System.in).nextLine();
            winConditionFulfilled = true;
        } else {
            DiceGamePlayer next = playerId + 1 == playerList.size() ? playerList.get(0) : playerList.get(playerId + 1);
            System.out.printf("Give the computer to the next player, %s and press enter to proceed\n", next.getName());
            new Scanner(System.in).nextLine();
        }
    }

    @Override
    public void displayWinner() {
        String spacer = "=".repeat(30);
        System.out.println(spacer);
        System.out.println("|         Scoreboard         |");
        System.out.println(spacer);
        System.out.println("| Rank | Name      | Score   |");
        System.out.println(spacer);
        playerList.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        for (DiceGamePlayer player : playerList) {
            String name = player.getName();
            String score = String.format("%s", player.getScore());
            String rank = "#" + (playerList.indexOf(player) + 1);
            System.out.println("| " + " ".repeat(4 - rank.length()) + rank +
                    " | " + name + " ".repeat(10 - name.length()) +
                    "| " + score + " ".repeat(8 - score.length()) +
                    "|");
        }
        System.out.println(spacer);
    }
}
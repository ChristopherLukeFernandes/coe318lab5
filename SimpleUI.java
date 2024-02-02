package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {

    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House holds: " + this.game.getHouseCards().toString());
        System.out.println("You hold: " + this.game.getYourCards().toString());
    }

    @Override
    public boolean hitMe() {
        System.out.println("Would you like a hit? (Y/N)");
        String userChoice = user.nextLine();
        boolean hit = false;
        switch (userChoice) {
            case "Y":
                hit = true;
                break;
            case "N":
                hit = false;
                break;
            default:
                System.out.println("You must type either Y or N");
                hitMe();
        }
        return hit;
    }

    @Override
    public void gameOver() {
        this.display();
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        System.out.println("House Score: "
                + houseScore
                + " Your Score: "
                + yourScore);
        if ((yourScore > houseScore || houseScore > 21) && (yourScore <= 21)) {
            System.out.println("You Win!");
        } else if (yourScore == houseScore) {
            System.out.println("Push!");
        } else {
            System.out.println("House Wins!");
        }
        System.out.println("Thanks for playing!");
    }
}

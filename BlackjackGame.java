package coe318.lab5;

public class BlackjackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;
    private boolean stillGame = true;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        for (int i = 2;
                i < 15;
                i++) {
            for (int j = 0;
                    j < 4;
                    j++) {
                deck.add(new Card(i, j, true));
            }
        }
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() {
        while (score(getHouseCards()) <= 17) {
            getHouseCards().add(deck.removeRandom());
            ui.display();
        }
        if (score(getHouseCards()) >= 21) {
            stillGame = false;
        }
        if (stillGame) {
            while (!(score(getYourCards()) > 20) && ui.hitMe()) {
                getYourCards().add(deck.removeRandom());
                ui.display();
            }
            if (score(getYourCards()) > 20) {
                stillGame = false;
            }
        }
    }

    public void end() {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

    public int score(CardPile p) {
        int score = 0;
        for (Card card : p.getCards()) {
            score += card.value();
        }
        return score;
    }

    public CardPile getHouseCards() {
        return houseCards;
    }

    public CardPile getYourCards() {
        return yourCards;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}

package coe318.lab5;

public class Card implements Comparable {

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    int rnk, suit1;
    boolean faceUp1;

    public Card(int rank, int suit, boolean faceUp) {
        rnk = rank;
        suit1 = suit;
        faceUp1 = faceUp;
    }

    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
        return faceUp1;
    }

    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {

        faceUp1 = faceUp;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rnk;
    }

    /**
     * @return the suit
     */
    public int getSuit() {
        return suit1;
    }

    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Card)) {
            return false;
        }
        Card c = (Card) ob;
        if (c.rnk == rnk && c.suit1 == suit1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    @Override
    public int compareTo(Object obj) {
        return compareTo((Card) obj);
    }

    public int compareTo(Card c) {
        if (this.rnk < c.rnk) {
            return -1;
        } else if (this.rnk > c.rnk) {
            return 1;
        }

        if (this.suit1 > c.suit1) {
            return 1;
        } else if (this.suit1 < c.suit1) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getRankString() {
        int rank = getRank();
        switch (rank) {
            case 11:
                return ("Jack");
            case 12:
                return ("Queen");
            case 13:
                return ("King");
            case 14:
                return ("Ace");
            default:
                return (Integer.toString(rnk));
        }
    }

    public String getSuitString() {
        int suit = getSuit();
        String s = "";
        switch (suit) {
            case 0:
                s = "Clubs";
                break;
            case 1:
                s = "Diamonds";
                break;
            case 2:
                s = "Hearts";
                break;
            case 3:
                s = "Spades";
                break;
        }
        return (s);
    }

    public int value() {
        if (this.rnk == 14) {
            return (1);
        } else if (this.rnk == 11) {
            return 10;
        } else if (this.rnk == 12) {
            return 10;
        } else if (this.rnk == 13) {
            return 10;
        } else {
            return (this.rnk);
        }

    }

    /**
     * Return "?" if the card is facedown; otherwise, the rank and suit of the
     * card.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        if (isFaceUp() == true) {
            return ""
                    + getRankString()
                    + " " + getSuitString();
        } else {
            return "?";
        }
    }

    public static void main(String[] args) {   //main function defined
        Card club5 = new Card(5, 0, true);
        System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println("spadeAce: " + spadeAce);
        System.out.println("club5 compareTo spadeAce: "
                + club5.compareTo(spadeAce));
        System.out.println("club5 compareTo club5: "
                + club5.compareTo(club5));
        System.out.println("club5 equals spadeAce: "
                + club5.equals(spadeAce));
        System.out.println("club5 equals club5: "
                + club5.equals(club5));
    }
}

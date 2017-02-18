package Game;


class Card {
    private String suit;
    private int value;

    Card(int value, int suit) {
        String[] possibleSuits = {"Hearts", "Spades", "Diamonds", "Clubs"};

        this.value = value;
        this.suit = possibleSuits[suit];
    }

    String getSuit() {
        return suit;
    }

    int getValue() {
        return value;
    }
}

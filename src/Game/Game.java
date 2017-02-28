package Game;


class Game {
    private Deck playersDeck = new Deck();
    private Deck computersDeck = new Deck();
    private int playerScore = 0;
    private int computerScore = 0;

    boolean gameInProgress = true;

    Game() {
        playersDeck.shuffleDeck();
        computersDeck.shuffleDeck();
    }

    void playerPlaysCard() {
        Card playersCard = playersDeck.pickTopCard();
        Card computersCard = computersDeck.pickTopCard();

        evaluateRoundWinner(playersCard, computersCard);
        System.out.println(playersDeck.cardsInDeck() + " cards left to play.");
    }

    void doWeHaveWinner() {
        if (playersDeck.isDeckEmpty()) {
            System.out.println();

            if (playerScore > computerScore) {
                System.out.println("You have won. Congratulations!");
            } else if (computerScore > playerScore) {
                System.out.println("You have lost. Try again!");
            } else {
                System.out.println("It's a draw. Everyone is a winner!");
            }

            System.out.println();
            gameInProgress = false;
        }
    }

    String printPlayedCard(Card c) {
        int valueInt = c.getValue();
        String valueString;

        switch (valueInt) {

            case 11:
                valueString = "Jack";
                break;
            case 12:
                valueString = "Queen";
                break;
            case 13:
                valueString = "King";
                break;
            case 14:
                valueString = "Ace";
                break;

            default:
                valueString = String.valueOf(valueInt);
        }
        System.out.println(valueString + " of " + c.getSuit());
        return valueString + " of " + c.getSuit();
    }

    private int compareCardValues(Card c1, Card c2) {
        int winner = 0;

        if (c1.getValue() > c2.getValue()) {
            winner = 1;
        }

        if (c2.getValue() > c1.getValue()) {
            winner = 2;
        }


        return winner;
    }

    private void emptyLine() {
        System.out.println();
    }

    private void printBothCards(Card playersCard, Card computersCard) {
        System.out.print("Player played: ");
        printPlayedCard(playersCard);

        System.out.print("Computer played: ");
        printPlayedCard(computersCard);
    }

    private void evaluateRoundWinner(Card playersCard, Card computersCard) {
        int winner = compareCardValues(playersCard, computersCard);

        printBothCards(playersCard, computersCard);
        emptyLine();

        if (winner == 1) {
            playerScore++;
            System.out.println("Player has won a point!");
        } else if (winner == 2) {
            computerScore++;
            System.out.println("Computer has won a point!");
        } else {
            System.out.println("It's a draw!");
        }

        printScore();

    }

    private void printScore() {
        System.out.println("Player has " + playerScore + " points, computer has " + computerScore + " points.");
    }
}

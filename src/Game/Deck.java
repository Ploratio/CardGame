package Game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Card> deck = new ArrayList<Card>();

    Deck() {
        createNewDeck();
    }

    int getValueOfCard(int position) {
        return deck.get(position).getValue();
    }

    String getColourOfCard(int position) {
        return deck.get(position).getSuit();
    }

    int cardsInDeck() {
        return deck.size();
    }

    Card pickTopCard() {
        Card topCard = getCardObject(0);
        destroyCard(0);
        return topCard;
    }

    Card getCardObject(int position) {
        return deck.get(position);
    }

    boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    void shuffleDeck() {
        Random r = new Random();
        List<Card> shuffledDeck = new ArrayList<Card>();

        shuffle(r, shuffledDeck, cardsInDeck());
        deck = shuffledDeck;
    }

    private void createNewDeck() {
        for (int cardColour = 0; cardColour < 4; cardColour++) {
            for (int cardValue = 2; cardValue <= 14; cardValue++) {
                Card card = new Card(cardValue, cardColour);
                deck.add(card);
            }
        }
    }

    private void shuffle(Random r, List<Card> shuffledDeck, int deckSize) {
        for (int shufflingPosition = 0; shufflingPosition < deckSize; shufflingPosition++) {
            int randomPositionOrigin = r.nextInt(cardsInDeck());

            shuffledDeck.add(getCardObject(randomPositionOrigin));
            destroyCard(randomPositionOrigin);
        }
    }

    private void destroyCard(int position) {
        deck.remove(position);
    }


}

package Game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck = new ArrayList<Card>();

    Deck() {
        createNewDeck();
    }

    public int getValueOfCard(int position) {
        return deck.get(position).getValue();
    }

    public String getColourOfCard(int position) {
        return deck.get(position).getColour();
    }

    public int getNumberOfCardsInDeck() {
        return deck.size();
    }

    private void destroyCard(int position) {
        deck.remove(position);
    }

    public Card pickCardUp() {
        Card topCard = getCardObject(0);
        destroyCard(0);
        return topCard;
    }

    public Card getCardObject(int position) {
        Card anyCard = deck.get(position);
        return anyCard;
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public void shuffleDeck() {
        Random r = new Random();
        int deckSize = getNumberOfCardsInDeck();
        List<Card> shuffledDeck = new ArrayList<Card>();

        shuffle(r, shuffledDeck, deckSize);
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
            int randomPositionOrigin = r.nextInt(deck.size());

            shuffledDeck.add(deck.get(randomPositionOrigin));
            deck.remove(randomPositionOrigin);
        }
    }
}

package Game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CardTests {

    private void testCardColourAndValue(Deck d, int position, int expectedValue, String expectedColour) {
        assertEquals(expectedValue, d.getValueOfCard(position));
        assertEquals(expectedColour, d.getColourOfCard(position));
    }

    @Before
    public void canCreateGame() throws Exception {
        Game g = new Game();
    }

    @Test
    public void canCreateDeck() throws Exception {
        Deck d1 = new Deck();
        Deck d2 = new Deck();
    }

    @Test
    public void canCreateCard() throws Exception {
        Card c = new Card(2, 0);

        assertEquals("Hearts", c.getColour());
        assertEquals(2, c.getValue());
    }

    @Test
    public void deckHasCards() throws Exception {
        Deck d = new Deck();
        assertEquals(52, d.getNumberOfCardsInDeck());
    }

    @Test
    public void cardsAreCorrect() throws Exception {
        Deck d = new Deck();

        testCardColourAndValue(d, 0, 2, "Hearts");
        testCardColourAndValue(d, 12, 14, "Hearts");
        testCardColourAndValue(d, 25, 14, "Spades");
        testCardColourAndValue(d, 38, 14, "Diamonds");
        testCardColourAndValue(d, 51, 14, "Clubs");
    }



    @Test
    public void canShuffleDeck() throws Exception {
        Deck d = new Deck();
        int cardsInDeck = d.getNumberOfCardsInDeck();
        d.shuffleDeck();
        assertEquals(cardsInDeck, d.getNumberOfCardsInDeck());
        
        if (d.getColourOfCard(0) == "Hearts" || d.getColourOfCard(0) == "Spades" || d.getColourOfCard(0) == "Diamonds" || d.getColourOfCard(0) == "Clubs") {
        } else {
            fail("First card is empty!");
        }
        
        if (d.getValueOfCard(0) == 2 && d.getValueOfCard(1) == 3 && d.getValueOfCard(2) == 4) {
            fail("Cards are not shuffled!");
        }
    }

    @Test
    public void canTakeFromTop() throws Exception {
        Deck d = new Deck();
        Card c = d.getCardObject(1);
        d.pickCardUp();
        assertEquals(c, d.getCardObject(0));
        assertEquals(51, d.getNumberOfCardsInDeck());
    }

    @Test
    public void canEmptyDeck() throws Exception {
        Deck d = new Deck();
        int cardsInDeck = d.getNumberOfCardsInDeck();
        for (int i = 0; i < cardsInDeck; i++) {
            d.pickCardUp();
        }
        assertTrue(d.isDeckEmpty());
    }
}
import junit.framework.TestCase;

public class DeckTest3 extends TestCase {
    private Deck deck;
    private int total = 52;
    private int difTotal = 32;
    private int min;

    void setMin() {
        switch (total) {
            case 52:
                min = 2;
                break;
            case 32:
                min = 7;
                break;
            case 24:
                min = 9;
                break;
        }
    }


    protected void setUp() throws Exception {
        deck = new Deck(total);
        setMin();
    }

    public void testShuffleKeepsAllCards() throws Exception {
        deck.shuffle();
        assertEquals(total, deck.cards.length);
    }

    public void testSortStartsWithMinValue() throws Exception {
        deck.shuffle();
        deck.sort();
        assertEquals(min, deck.cards[0].value);
    }

    public void testReturnTopIsNotNull() throws Exception {
        assertNotNull(deck.returnTop());
    }

    public void testOnlySetAmountOfCards() throws Exception {
        assertNull(deck.cards[total]);
    }

    public void testConstructorCreatesDifferentDecks() throws Exception {
        Deck testDeck = new Deck(difTotal);
        assertNotSame(testDeck, deck);
    }

}
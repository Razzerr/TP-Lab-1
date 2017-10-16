import static org.junit.Assert.*;

public class DeckTest4 {
    private Deck deck;
    private int total = 52;
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

    @org.junit.Before
    public void setUp() throws Exception {
        deck = new Deck(total);
        setMin();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Testing done");
    }

    @org.junit.Test
    public void testShuffleKeepsAllCards() throws Exception {
        assertEquals(total, deck.cards.length);
    }

    @org.junit.Test
    public void testSortStartsWithMinValue() throws Exception {
        deck.shuffle();
        deck.sort();
        assertEquals(min, deck.cards[0].value);
    }

    @org.junit.Test
    public void testReturnTopIsNotNull() throws Exception {
        assertNotNull(deck.returnTop());
    }

}
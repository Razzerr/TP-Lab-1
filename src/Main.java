public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck(52);
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            System.out.print("[Card]: " + deck.cards[i].color + ", " + deck.cards[i].value + "\n");
        }
        System.out.print("#######################\n");
        deck.sort();
        for (int i = 0; i < 52; i++) {
            System.out.print("[Card]: " + deck.cards[i].color + ", " + deck.cards[i].value + "\n");
        }
    }
}

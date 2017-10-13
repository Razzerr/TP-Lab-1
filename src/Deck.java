import java.util.Random;

class Deck {
    private Random rand = new Random();
    Card[] cards;

    Deck(int i) {
        switch (i) {
            case 52:
                cards = new Card[52];
                createDeck(52);
                break;
            case 32:
                cards = new Card[32];
                createDeck(32);
                break;
            case 24:
                cards = new Card[24];
                createDeck(24);
                break;
        }
    }

    //Methods
    void shuffle(){
        for (int i = 0; i<cards.length; i++){
            int j = rand.nextInt(cards.length);
            swapCards(i, j);
        }
    }

    void sort(){
        for(int i = 0; i<cards.length; i++){
            for(int j = 0; j<cards.length; j++){
                if (cards[i].value<cards[j].value && i>j){
                    swapCards(i, j);
                }
            }
        }
        for(int i = 0; i<cards.length; i++){
            for(int j = 0; j<cards.length; j++){
                if (cards[i].colorVal < cards[j].colorVal && i>j && cards[i].value == cards[j].value){
                    swapCards(i, j);
                }
            }
        }
    }

    Card returnTop() {
        return cards[cards.length - 1];
    }

    private void createDeck(int number){
        String color = "Error";
        int colorVal = -1;
        int minimum = -1;
        switch (number){
            case 52:
                minimum = 2;
                break;
            case 32:
                minimum = 7;
                break;
            case 24:
                minimum = 9;
                break;
        }
        for (int i = 0; i<number/4; i++){
            for (int j = 0; j<4; j++) {
                switch (j) {
                    case 0:
                        color = "Hearts";
                        colorVal = 1;
                        break;
                    case 1:
                        color = "Diamonds";
                        colorVal = 2;
                        break;
                    case 2:
                        color = "Clovers";
                        colorVal = 3;
                        break;
                    case 3:
                        color = "Spades";
                        colorVal = 4;
                        break;
                }
                cards[i*4+j] = new Card(color, colorVal, minimum + i);
            }
        }
    }

    private void swapCards(int i, int j){
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }
}
package amazon.design.pocker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PockerCards {

    Card[] cards = new Card[52];
    Random random = new Random();

    public PockerCards() {
        int i = 0;
        for (Value val : Value.values()) {
            for (Type type : Type.values()) {
//                for (Color color : Color.values()) {
                    cards[i++] = new Card(val, type);
//                }
            }
        }
    }

    public void shuffle() {
        for (int i = 51; i >= 0; i--) {
            int k = random.nextInt(i + 1);
            swap(k, i);
        }
//        print();
    }

    private void print() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    private void swap(int i, int j) {
        Card c = cards[i];
        cards[i] = cards[j];
        cards[j] = c;
    }

    public List<List<Card>> distribute(int slots, int round) {
        List<List<Card>> buckets = new ArrayList<>();
        for (int j = 0; j < slots; j++) {
            buckets.add(new ArrayList<>());
        }

        int k = 0;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < slots; j++) {
                buckets.get(j).add(cards[k++]);
            }
        }

        return buckets;
    }

    public static void main(String[] args) {
        PockerCards pocker = new PockerCards();
        pocker.shuffle();

        for (List<Card> cards : pocker.distribute(4,4))
            System.out.println(cards);
    }
}

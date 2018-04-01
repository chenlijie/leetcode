package ebay.design.vendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class VendingMachine {

    State emptyState;
    State noMoneyState;
    State hasMoneyState;
    State dispensingState;
    State currentState;

    double balance = 0.0;
    Map<Integer, Bucket> buckets;
    int count;

    public VendingMachine(int size) {
        emptyState = new EmptyState(this);
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);

        buckets = new HashMap<>();
        for (int i = 0; i < size; i++) {
            buckets.put(i, new Bucket());
        }

        currentState = emptyState;
    }

    public void insertMoney(double money) {
        try {
            currentState.insertMoney(money);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pressButton(int bucketId) {
        try {

            currentState.pressButton(bucketId);
            Item item = buckets.get(bucketId).getItem();
            item.decreaseQuantity();
            balance -= item.price;
            currentState.dispense();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void refill(int bucketId, int quantity) {
        Item item = buckets.get(bucketId).getItem();
        item.quantity += quantity;
        count += quantity;
        currentState = noMoneyState;
    }

    public void addOrReplaceItem(int bucketId, String description, double price, int quantity) {
        buckets.get(bucketId).setItem(new Item(description, price, quantity));
        count += quantity;
        currentState = noMoneyState;
    }

    public void changeState(State state) {
        currentState = state;
    }
}

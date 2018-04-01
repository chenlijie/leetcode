package ebay.design.vendingMachine;

public class EmptyState implements State {

    VendingMachine machine;

    public EmptyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(double money) {
        throw new RuntimeException("Out of stock");
    }

    @Override
    public void pressButton(int bucketId) {
        throw new RuntimeException("Invalid Action");
    }

    @Override
    public void dispense() {
        throw new RuntimeException("Invalid Action");
    }
}

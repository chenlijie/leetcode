package ebay.design.vendingMachine;

public class HasMoneyState implements State {

    VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(double money) {
        machine.balance = money;
        System.out.println("Current balance is $ " + machine.balance);
    }

    @Override
    public void pressButton(int bucketId) {
        Item item = machine.buckets.get(bucketId).getItem();
        if (item == null)
            throw new RuntimeException("Bucket is empty");

        if (item.getQuantity() == 0)
            throw new RuntimeException("Bucket is empty, " + item.getDescription() + " is out of stock now");

        if (machine.balance < item.getPrice())
            throw new RuntimeException("Please insert more money");

        machine.changeState(machine.dispensingState);
    }

    @Override
    public void dispense() {

    }
}

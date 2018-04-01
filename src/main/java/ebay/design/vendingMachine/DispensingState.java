package ebay.design.vendingMachine;

public class DispensingState implements State {

    VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(double money) {
        System.out.println("Previous transaction is in progress, please wait ...");
        throw new RuntimeException("transaction is in progress");
    }

    @Override
    public void pressButton(int bucketId) {
        System.out.println("Previous transaction is in progress, please wait ...");
        throw new RuntimeException("transaction is in progress");
    }

    @Override
    public void dispense() {
        System.out.println("Please collect your item and changes $ " + machine.balance);

        if (machine.count == 0)
            machine.changeState(machine.emptyState);
        else
            machine.changeState(machine.noMoneyState);

        machine.balance = 0.0;
    }
}

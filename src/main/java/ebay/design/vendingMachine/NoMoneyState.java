package ebay.design.vendingMachine;

public class NoMoneyState implements State {

    VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(double money) {
        machine.balance = money;
        machine.changeState(machine.hasMoneyState);
        System.out.println("Current balance is $ " + machine.balance);
    }

    @Override
    public void pressButton(int bucketId) {
        throw new RuntimeException("Please insert money");
    }

    @Override
    public void dispense() {

    }
}

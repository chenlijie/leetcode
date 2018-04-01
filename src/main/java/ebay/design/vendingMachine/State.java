package ebay.design.vendingMachine;

interface State {
    void insertMoney(double money);

    void pressButton(int bucketId) throws RuntimeException;

    void dispense();
}

package ebay.design.vendingMachine;

public class MachineTest {

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(8);

        //empty state
        machine.insertMoney(1.0);
        machine.pressButton(1);
        System.out.println();

        System.out.println("****** Add items *******");
        machine.addOrReplaceItem(0, "coke", 1.50, 1);
        machine.addOrReplaceItem(1, "juice", 2.00, 2);
//        machine.addOrReplaceItem(2, "chips", 0.99, 3);
//        machine.addOrReplaceItem(3, "cookie", 3.50, 4);
//        machine.addOrReplaceItem(4, "orange", 11.00, 5);

        System.out.println();

        System.out.println("****** No Money *******");
        //no money state
        machine.pressButton(0);

        System.out.println();

        System.out.println("****** Insert Money *******");
        //has money state
        machine.insertMoney(1.0);
        machine.pressButton(0);
        machine.insertMoney(2.0);
        machine.pressButton(0);


        //insert money
        machine.insertMoney(10.0);
        machine.pressButton(0);
        machine.pressButton(1);
    }
}

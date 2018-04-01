package ebay;

public class MyInterfaceImp implements MyInterface {

    public void test() {

    }


    public static void main(String[] args) {
        MyInterface my = new MyInterfaceImp();
        System.out.println(MyInterface.a);
        System.out.println(a);
    }
}

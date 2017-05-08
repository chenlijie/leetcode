package sort;

/**
 * Created by chenlijie on 5/1/17.
 */
public class TopDownListMergeSort {


    public Node TopDownListMerge(Node head) {

        int size = 0;
        Node node = head;

        while (node != null) {
            size++;
            node = node.next;
        }

        return TopDownListMerge(head, size);
    }

    private Node TopDownListMerge(Node node, int size) {

        if (size/2 >= 1) {
            Node node1 = node;
            Node node2 = node;
            for (int i = 0; i < size/2; i++) {
                node1 = node2;
                node2 = node2.next;
            }
            node1.next = null;

            node1 = TopDownListMerge(node, size/2);
            node2 = TopDownListMerge(node2, size - size/2);

            return mergeList(node1, node2);
        } else {
            return node;
        }
    }


    public Node mergeList(Node list1, Node list2) {
        Node dummy = new Node();
        Node next = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                next.next = list1;
                list1 = list1.next;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }

        if (list1 != null) {
            next.next = list1;
        }
        if (list2 != null) {
            next.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        testMergeList();
//        testTopDownListMerge();
        testFinalTopDownListMerge();
    }

    static void testFinalTopDownListMerge() {
        Node list1 = new Node(2);
        Node list12 = new Node(3);
        Node list13 = new Node(5);

        Node list2 = new Node(1);
        Node list22 = new Node(4);
        Node list23 = new Node(6);
        Node list24 = new Node(8);
        Node list25 = new Node(10);

        list1.next = list12;
        list12.next = list13;
        list13.next = list2;

        list2.next = list22;
        list22.next = list23;
        list23.next = list24;
        list24.next = list25;

        Node node = new TopDownListMergeSort().TopDownListMerge(list1);

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    static void testTopDownListMerge() {
        Node list1 = new Node(2);
        Node list12 = new Node(3);
        Node list13 = new Node(5);

        Node list2 = new Node(1);
        Node list22 = new Node(4);
        Node list23 = new Node(6);
        Node list24 = new Node(8);
        Node list25 = new Node(10);

        list1.next = list12;
        list12.next = list13;
        list13.next = list2;

        list2.next = list22;
        list22.next = list23;
        list23.next = list24;
        list24.next = list25;

        Node node = new TopDownListMergeSort().TopDownListMerge(list1, 5);

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }


    static void testMergeList() {
        Node list11 = new Node(2);
        Node list12 = new Node(3);
        Node list13 = new Node(5);
        list11.next = list12;
        list12.next = list13;

        Node list21 = new Node(1);
        Node list22 = new Node(4);
        Node list23 = new Node(6);
        Node list24 = new Node(8);
        Node list25 = new Node(10);
        list21.next = list22;
        list22.next = list23;
        list23.next = list24;
        list24.next = list25;

        list11 = new TopDownListMergeSort().mergeList(list11, list21);

        while (list11 != null) {
            System.out.print(list11.val + ", ");
            list11 = list11.next;
        }
    }
}

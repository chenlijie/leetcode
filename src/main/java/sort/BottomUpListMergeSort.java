package sort;

/**
 * Created by chenlijie on 5/1/17.
 */
public class BottomUpListMergeSort {


    public Node bottomUp(Node head) {

        if (head == null)
            return null;
        Node[] array = new Node[32]; 
        Node result;
        Node next;
        int  i;
        result = head;
        // merge nodes into array
        while (result != null) {
            next = result.next;
            result.next = null;
            for(i = 0; (i < 32) && (array[i] != null); i += 1) {
                result = mergeList(array[i], result);
                array[i] = null;
            }
            // do not go past end of array
            if (i == 32)
                i -= 1;
            array[i] = result;
            result = next;
        }
        // merge array into single list
        result = null;
        for (i = 0; i < 32; i += 1)
            result = mergeList(array[i], result);
        return result;
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

        Node node = new BottomUpListMergeSort().bottomUp(list1);

        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

}

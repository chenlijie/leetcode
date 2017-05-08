package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by chenlijie on 5/7/17.
 */
public class Copy_List_with_Random_Pointer_138 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;
        RandomListNode copy;

        while (node != null) {

            map.putIfAbsent(node, new RandomListNode(node.label));

            copy = map.get(node);

            if (node.next != null) {
                map.putIfAbsent(node.next, new RandomListNode(node.next.label));
                copy.next = map.get(node.next);
            }

            if (node.random != null) {
                map.putIfAbsent(node.random, new RandomListNode(node.random.label));
                copy.random = map.get(node.random);
            }

            node = node.next;
        }

        return map.get(head);
    }


    public static void main(String[] args) {
        Copy_List_with_Random_Pointer_138.RandomListNode node1 = new Copy_List_with_Random_Pointer_138.RandomListNode(1);
        Copy_List_with_Random_Pointer_138.RandomListNode node2 = new Copy_List_with_Random_Pointer_138.RandomListNode(2);
        Copy_List_with_Random_Pointer_138.RandomListNode node3 = new Copy_List_with_Random_Pointer_138.RandomListNode(3);
        Copy_List_with_Random_Pointer_138.RandomListNode node4 = new Copy_List_with_Random_Pointer_138.RandomListNode(4);
        Copy_List_with_Random_Pointer_138.RandomListNode node5 = new Copy_List_with_Random_Pointer_138.RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node5;
        node2.random = node5;

        node4.random = node1;

        Copy_List_with_Random_Pointer_138.RandomListNode copy = new Copy_List_with_Random_Pointer_138().copyRandomList(node1);

        System.out.println(copy);
    }
}

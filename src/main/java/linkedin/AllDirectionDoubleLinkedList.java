package linkedin;


/**
 * Created by chenlijie on 12/8/17.
 */
public class AllDirectionDoubleLinkedList {
    //双向链表，但是每一个点还可以有up，down pointer，
    //已知一个链表里没有环，要求把这个链表变成标准双向链表，要求O(n)time, O(1)space.
    //有环，去除环，返回无环的链表
    static class MLinkedNode {
        int val;
        MLinkedNode up;
        MLinkedNode down;
        MLinkedNode pre;
        MLinkedNode next;

        public MLinkedNode(int val) {
            this.val = val;
        }
    }

    MLinkedNode getDoubleLinkedList(MLinkedNode head) {

        MLinkedNode cur = head;
        while (cur != null) {
            explore(cur, cur.up, true); //explore up node
            explore(cur, cur.down, false); //explore down node
            cur = cur.next;
        }
        return head;
    }

    void explore(MLinkedNode cur, MLinkedNode node, boolean isUP) {
        if (node != null) {
            MLinkedNode leftMost = getLeftOrRightMost(node, true);
            MLinkedNode rightMost = getLeftOrRightMost(node, false);

            rightMost.next = cur.next;
            cur.next.pre = rightMost;

            cur.next = leftMost;
            leftMost.pre = cur;

            if (isUP) {
                node.down = null;
                cur.up = null;
            } else {
                node.up = null;
                cur.down = null;
            }
        }
    }

    MLinkedNode getLeftOrRightMost(MLinkedNode node, boolean isLeft) {
        if (isLeft) {
            while (node.pre != null) {
                node = node.pre;
            }
        } else {
            while (node.next != null) {
                node = node.next;
            }
        }
        return node;
    }


    public static void main(String[] args) {
        AllDirectionDoubleLinkedList all = new AllDirectionDoubleLinkedList();
        MLinkedNode f1 = new MLinkedNode(1);
        MLinkedNode f2 = new MLinkedNode(2);
        MLinkedNode f3 = new MLinkedNode(3);
        MLinkedNode f4 = new MLinkedNode(4);
        MLinkedNode f5 = new MLinkedNode(5);
        MLinkedNode f6 = new MLinkedNode(6);
        MLinkedNode f7 = new MLinkedNode(7);
        MLinkedNode f8 = new MLinkedNode(8);

        MLinkedNode f0 = new MLinkedNode(1);

        f1.next = f2;
        f2.pre = f1;

        f2.next = f3;
        f3.pre = f2;

        f2.up = f5;
        f5.down = f2;

        f5.next = f6;
        f6.pre = f5;

        f4.next = f5;
        f5.pre = f4;

        f4.up = f7;
        f7.down = f4;

        f4.down = f8;
        f8.up = f4;

//        f8.down = f1;
//        f1.up = f8;

//        f6.down = f3;
//        f3.up = f6;

        all.print(all.getDoubleLinkedList(f1));

    }

    void print(MLinkedNode list) {
        while (list != null) {
            if (list.up != null || list.down != null)
                System.out.println("XXXXXX");
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}

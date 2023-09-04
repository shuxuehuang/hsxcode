package algo.linkedlist;

public class LinkedListAlgo {
    class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    /**
     * 单链表反转
     */
    public Node reverse(Node head){
        if (head == null){
            return null;
        }
        Node pre = null;
        Node p = head;
        Node next = null;
        while (p != null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    /**
     * 链表中环的检测
     */
    public boolean checkCycle(Node head){
        if (head == null){
            return false;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 两个有序链表合并
     */
    public Node merge(Node headA, Node headB){
        if (headA == null){
            return headB;
        }
        if (headB == null){
            return headA;
        }
        Node p1 = headA, p2 = headB;
        Node dummy = new Node(-1, null);
        Node tail = dummy;
        while(p1 != null && p2 != null){
            if (p1.value < p2.value){
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            }else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null){
            tail.next = p1;
        }
        if (p2 != null){
            tail.next = p2;
        }
        return dummy.next;
    }
    /**
     * 删除链表倒数第n个节点
     */
    public Node deleteNode(Node head, int k){
        if (head == null){
            return null;
        }
        Node p1 = head;
        while (k > 0){
            p1 = p1.next;
            k--;
        }
        Node p2 = head;
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
    /**
     * 求链表的中间节点
     */
    public Node findMid(Node head){
        if (head == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

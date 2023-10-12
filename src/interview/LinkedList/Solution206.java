package interview.LinkedList;

import codetemplate.ListNode;
import org.w3c.dom.ls.LSException;
import sun.plugin2.gluegen.runtime.StructAccessor;

import java.util.List;
import java.util.PriorityQueue;

public class Solution206 {

    public ListNode reverseList(ListNode head) {
        //反转链表
        ListNode dummy = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //反转链表2
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode cur = p.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = p.next;
            p.next = next;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //k个一组反转链表
        if (head == null){
            return head;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            //不足k个不做反转
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public ListNode reverse(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode cur = a;
        while (cur != b){
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                tail.next = p1;
                p1 = p1.next;
            }else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        if (p1 != null){
            tail.next = p1;
        }
        if (p2 != null){
            tail.next = p2;
        }
        return dummy.next;
    }
    /*public ListNode mergeKLists(ListNode[] lists) {
        //合并k个升序链表
        ListNode newList = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            newList = mergeTwoLists(lists[i], newList);
        }
        return newList;
    }*/
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists){
            queue.add(head);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;
            tail.next = null;
            if (poll.next != null){
                queue.add(poll.next);
            }
        }
        return dummy.next;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        //找到环的起点*******
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (slow == null || fast == null) return null;
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public int kthToLast(ListNode head, int k) {
        //找到链表倒数第k个节点
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.val;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int temp = n - 1;
        ListNode p1 = head;
        for (int i = 0; i < temp; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next != null ? p2.next.next : null;
        return dummy.next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //返回两个链表的第一个公共节点!!!!!!!!!!!!!!!!!!
       //！！！！！！！！！！！！
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            if (p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }
            if (p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }


        }
        return p1;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p1 = l1, p2 = l2;
        int add = 0;
        int value = 0;
        while (p1 != null && p2 != null){
            value = (p1.val + p2.val+ add) % 10 ;
            add = (p1.val + p2.val) / 10;
            tail.next = new ListNode(value);
            tail = tail.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null){

            value = (p1.val + add) % 10 ;
            add = (p1.val +add) / 10;
            tail.next = new ListNode(value);
            tail = tail.next;
            p1= p1.next;
        }
        while (p2 != null){
            value = (p2.val + add) % 10 ;
            add = (p2.val +add) / 10;
            tail.next = new ListNode(value);
            tail = tail.next;
            p2 = p2.next;
        }
        if (add != 0){
            tail.next = new ListNode(add);
            tail = tail.next;
        }
        return reverseList(dummy.next);
    }
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeTwoLists(list1, list2);
        return sorted;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        ListNode list2 = reverseList(slow);
        ListNode p1 = head, p2 = list2;
        while (p1 != null && p2 != null){
            if (p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode tailOdd = dummyOdd;
        ListNode tailEven = dummyEven;
        ListNode p = head;
        int index = 0;
        while (p != null ){
            ListNode next = p.next;
            if (index % 2 == 0){
                tailOdd.next = p;
                tailOdd = tailOdd.next;
                tailOdd.next = null;
            }else {
                tailEven.next = p;
                tailEven = tailEven.next;
                tailEven.next = null;
            }
            index++;
            p = next;
        }
        tailOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head, slow = head;
        while (slow != null){
            while (fast != null && fast.val == slow.val){
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
            fast = slow;
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            if (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}

package interview;
//翻转指定位置链表
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(5);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        reverseBetween(head, 1, 1);
    }
    /*
    * 如果是返回一个新的链表，一定要新建一个虚拟头节点
    * */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = pre;
        ListNode p = head;
        int temp = m;
        while (p != null && temp > 1){
            pre = p;
            p = p.next;
            temp--;
        }
        pre.next = null;
        int time = n - m + 1;
        ListNode next = p;
        tail = p;
        while (p != null && time > 0){
            next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = next;
            time --;
        }
        tail.next = next;
        return dummy.next;
    }
}
class ListNode{
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}

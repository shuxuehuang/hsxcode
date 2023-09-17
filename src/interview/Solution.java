package interview;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode listNode3 = solution.deleteDuplicates(listNode);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p = head;
        ListNode pre = dummy;
        while (p != null){
            ListNode next = p.next;
            if (p.val == tail.val){
                while (p.val == tail.val){
                    p = p.next;
                }
                pre.next = null;
                tail = pre;

            }else{
                if (dummy.next != null){
                    pre = tail;
                }
                tail.next = p;
                tail = tail.next;
                tail.next = null;
                p = next;
            }

        }
        return dummy.next;
    }
}

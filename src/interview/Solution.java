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
        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p = head;
//         while (p != null){
//             map.put(p.val, map.getOrDefault(p.val, 0) + 1);
//             p = p.next;
//         }
//         for (int key : map.keySet()){
//             if (map.get(key) == 1){
//                 tail.next = new ListNode(key);
//                 tail = tail.next;
//             }
//         }
        ListNode pre = dummy;
        while (p != null){
            if (p.val == tail.val){
                pre.next = null;
                tail = pre;
            }else{
                if (dummy.next != null){
                    pre = tail;

                }
                ListNode next = p.next;
                tail.next = p;
                tail = tail.next;
                tail.next = null;
                p = p.next;

            }

        }
        return dummy.next;
    }
}

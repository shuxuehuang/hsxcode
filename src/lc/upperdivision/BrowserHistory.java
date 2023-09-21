package lc.upperdivision;

import algo.linkedlist.SinglyLinkedList;

//rating 1454
public class BrowserHistory {
    Node dummy = new Node("dummy");
    Node cur = dummy;
    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        dummy.next = node;
        node.prev = dummy;
        cur = cur.next;
    }

    public void visit(String url) {
        Node node = new Node(url);
        cur.next = node;
        node.prev = cur;
        cur = cur.next;
    }

    public String back(int steps) {
        while (steps > 0 && cur.prev != dummy){
            cur = cur.prev;
            steps--;
        }
        return cur.val;
    }

    public String forward(int steps) {
        while (cur.next != null && steps > 0){
            cur = cur.next;
            steps--;
        }
        return cur.val;
    }
}
class Node{
    Node prev;
    Node next;
    String val;

    public Node(String val) {
        this.val = val;
    }
}


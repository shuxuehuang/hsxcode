package algo.linkedlist;

public class SinglyLinkedList {
    private Node head;

    public Node createNode(int data){
        return new Node(data, null);
    }
    public void deleteByNode(Node p){
        if (p == null || head == null){
            return;
        }
        if (p == head){
            head = head.next;
            return;
        }
        Node q = head;
        while(q != null && q.next != p){
            q = q.next;
        }
        if (q == null){
            return;
        }
        q.next = q.next.next;
    }
    public void deleteByValue(int value){
        if (head == null){
            return;
        }
        Node p = head;
        Node q = null;
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }
        if (p == null){
            return;
        }
        if (q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }

    }
    public Node findByIndex(int index){
        Node p = head;
        while (p != null && index > 0){
            p = p.next;
            index--;
        }
        return p;
    }
    public Node findByValue(int value){
        Node p = head;
        while (p != null && p.data != value){
            p = p.next;
        }
        return p;
    }
    public void insertAfter(Node p, Node newNode){
        if (p == null){
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }
    public void insertAfter(Node p, int value){
        Node node = new Node(value, null);
        insertAfter(p, node);
    }
    public void insertBefore(Node p, int value){
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }
    public void insertBefore(Node p, Node newNode){
        if (p == null){
            return;
        }
        if (head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if (q == null){
            return;
        }
        q.next = newNode;
        newNode.next = p;
    }

    private void insertToHead(Node newNode) {
        if (newNode == null){
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }
    public void insertTail(int value){
        if (head == null){
            head = new Node(value, null);
            return;
        }
        Node node = new Node(value, null);
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = node;
    }
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        Node next = null;
        while (r != p){
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        return pre;
    }
    public Node inverseLinkList_head(Node p){
        Node dummy = new Node(-1, null);
        Node next = null;
        while (p != null){
            next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

    public boolean palindrome(){
        if (head == null){
            return false;
        }
        Node p = head;
        Node q = head;
        if (p.next == null){
            return true;
        }
        while (q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }
        Node left = null;
        Node right = null;
        System.out.println("p :" + p.data);
        if (q != null && q.next == null){
            left = inverseLinkList(p);
            right = p.next;
            System.out.println("1111");
        }else{
            right = p;
            left = inverseLinkList(p);
        }
        System.out.println("left:" + left.data);
        System.out.println("right:" + right.data);
        return TFResult(left, right);
    }

    private boolean TFResult(Node left, Node right) {
        if (left == null || right == null){
            return false;
        }
        Node p = left;
        Node q = right;
        while (p != null && q != null){
            if (p.data != q.data){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
//        int data[] = {1};
//        int data[] = {1,2};
//        int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
//        int data[] = {1,2,2,1};
         int data[] = {1,2,5,2,1};
//        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }

    private void printAll() {
        Node p =head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
        System.out.println("============================");
    }

    public class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}

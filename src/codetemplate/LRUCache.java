package codetemplate;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map ;
    DoubleList cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        makeKeyRecent(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            makeKeyRecent(node);
            return;
        }
        if (map.size() < capacity){
           addKey(new Node(key, value));
           return;
        }
        updateCache(new Node(key, value));
    }
    private void makeKeyRecent(Node x){
        cache.deleteNode(x);
        cache.addLast(x);
    }
    private void addKey(Node x){
        cache.addLast(x);
        map.put(x.key, x);
    }
    private void updateCache(Node x){
        //删掉第一个
        Node oldNode = cache.deleteFirst();
        map.remove(oldNode.key);
        //加上最新的
        cache.addLast(x);
        map.put(x.key, x);
    }

}
class Node {
    int key, val;
    Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class DoubleList {
    Node head;
    Node tail;

    public DoubleList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    //删除某个节点
    public void deleteNode(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        x.prev = null;
        x.next = null;
    }
    //删除第一个节点并返回
    public Node deleteFirst(){
        if (head.next == tail){
            return null;
        }
        Node node = head.next;
        deleteNode(node);
        return node;
    }
    //在链表尾部加入节点
    public void addLast(Node x){
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
    }
}

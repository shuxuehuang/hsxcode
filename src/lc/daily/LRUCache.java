package lc.daily;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    DoubleList doubleList = new DoubleList();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        makeRecently(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.get(key).value = value;
            makeRecently(map.get(key));
            return;
        }
        Node newNode = new Node(key, value);
        if (map.size() == capacity){
            Node node = doubleList.removeFirst();
            map.remove(node.key);
        }
        doubleList.addLast(newNode);
        map.put(key, newNode);
    }
    public void makeRecently(Node node){
        doubleList.remove(node);
        doubleList.addLast(node);
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}
class DoubleList{
    Node dummy = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public DoubleList() {
        dummy.next = tail;
        tail.prev = dummy;
    }
    public void remove(Node x){
        //删除某个节点
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
    public void addLast(Node x){
        x.next = tail;
        tail.prev.next = x;
        x.prev = tail.prev;
        tail.prev = x;
    }

    public Node removeFirst(){
        if (dummy.next == tail){
            return null;
        }
        Node first = dummy.next;
        remove(first);
        return first;
    }
}

package codetemplate;
/*
* 手动实现大顶堆优先级队列
* */
public class MxPq<key extends Comparable<key>> {
    private key[] pq;
    //当前优先级队列里面有的元素个数
    private int size = 0;

    public MxPq(int n) {
        pq = (key[]) new Comparable[size + 1];
    }
    public void swim(int x){
        while (x > 1 && less(parent(x), x)) {
            swap(x, parent(x));
            x = parent(x);
        }
    }
    public void sink(int x){
        while (left(x) <= size){
            int max = left(x);
            if (right(x) <= size && less(max, right(x))){
                max = right(x);
            }
            if (less(max, x)) break;
            swap(x, max);
            x = max;
        }
    }
    public void insert(key e){
        size++;
        pq[size] = e;
        swim(size);
    }
    public key delete(){
        key max = pq[1];
        swap(1, size);
        pq[size] = null;
        size--;
        sink(1);
        return max;
    }
    private int left(int n){
        return n * 2;
    }
    private int right(int n){
        return n * 2 + 1;
    }
    private int parent(int n){
        return n / 2;
    }
    private void swap(int x, int y){
        key temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }
    private boolean less (int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
}

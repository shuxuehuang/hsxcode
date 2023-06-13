package algo.array;

public class Array {
    private int[] data;
    //当前数组长度
    private int n;
    //实际存储数据的大小
    private int count;

    public Array(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.count = 0;

    }
    public void printAll(){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }

    public int find(int index) {
        if (index < 0 || index >= count){
            return -1;
        }
        return data[index];
    }
    public boolean insert(int index,int value){
        if (index < 0 || index > count){
            return false;
        }
        if (count == n){
            //数组已满
            return false;
        }
        for (int i = count - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }
    public boolean delete(int index){
        if (index >= count || index < 0){
            return  false;
        }
        for (int i = index + 1; i < count; i++){
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}

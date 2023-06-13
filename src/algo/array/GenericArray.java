package algo.array;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] data;
    private int size;
    public GenericArray(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public GenericArray() {
        this(10);
    }
    public void add(int index, T value){
        checkIndexForAdd(index);
        if (size == data.length){
            resize(2 * data.length);
        }
        for (int i = size; i > index; i--){
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }
    public void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    public void addFirst(T value){
        add(0, value);
    }

    public void addLast(T value){
        add(size, value);
    }
    public boolean contains(T value){
        for (int i = 0; i < data.length; i++){
            if (data[i].equals(value)){
                return true;
            }
        }
        return false;
    }
    public int count(){
        return size;
    }
    public int find(T value){
        for (int i = 0; i < data.length; i++){
            if (data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T remove(int index){
        checkIndex(index);
        T ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }
    public void removeElement(T e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }

    }
    public void removeFirst(){
        remove(0);
    }
    public void removeLast(){
        remove(size - 1);
    }
    public void set(int index, T value){
        checkIndex(index);
        data[index] = value;
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }
}

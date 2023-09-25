package lc.daily;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    Map<Integer, Integer> keyToValue;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)){
            return -1;
        }
        increasFreq(key);
        return keyToValue.get(key);
    }

    private void increasFreq(int key){
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);
        freqToKeys.get(oldFreq).remove(key);
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
        if (freqToKeys.get(oldFreq).isEmpty()){
            freqToKeys.remove(oldFreq);
            if (oldFreq == minFreq){
                minFreq++;
            }
        }


    }

    public void put(int key, int value) {
        if (keyToValue.containsKey(key)){
            keyToValue.put(key, value);
            increasFreq(key);
            return;
        }
        if (keyToValue.size() == capacity){
            removeMinFreqKey();
        }
        addNewKey(key, value);
    }
    private void removeMinFreqKey(){
        LinkedHashSet<Integer> set = freqToKeys.get(minFreq);
        Integer needDeleteKey = set.iterator().next();
        set.remove(needDeleteKey);
        keyToValue.remove(needDeleteKey);
        keyToFreq.remove(needDeleteKey);
    }
    private void addNewKey(int key, int value){
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }
}


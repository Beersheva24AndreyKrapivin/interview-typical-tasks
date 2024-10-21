package telran.interview;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
    private HashMap<Integer, T> hashMap;
    private HashMap<Integer, Long> hashMapTimes;
    private T generalValue;
    private long lastTimeChange;
    private int size;

    public void setAll(T value) {
        // all array's elements should be set with a given value
        generalValue = value;
        lastTimeChange = System.currentTimeMillis();
    }

    public void set(int index, T value) {
        // set new value at a given index
        // throws ArrayIndexOutOfBoundsException for incorrect index
        if (index >= 0 && index < size) {
            hashMap.put(index, value);
            hashMapTimes.put(index, System.currentTimeMillis());
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        // returns a value at a given index
        // throws ArrayIndexOutOfBoundsException for incorrect index
        T value = null;
        if (index >= 0 && index < size) {
            if (hashMapTimes.getOrDefault(index, 0L) < lastTimeChange) {
                value = generalValue;
            } else {
                value = hashMap.get(index);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return value;
    }

    public MyArray(int size) {
        // creates the Array object for a given size
        // with setting null's at each element
        this.size = size;
        hashMap = new HashMap<>(size);
        hashMapTimes = new HashMap<>(size);
        lastTimeChange = -1;
    }
}
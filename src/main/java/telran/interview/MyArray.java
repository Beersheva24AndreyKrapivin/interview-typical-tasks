package telran.interview;

import java.util.HashMap;

//all methods must have complexity O[1]
public class MyArray<T> {
    private HashMap<Integer, T> hashMap;
    private T generalValue;
    private int size;

    public void setAll(T value) {
        // all array's elements should be set with a given value
        generalValue = value;
        hashMap = new HashMap<>();
    }

    public void set(int index, T value) {
        // set new value at a given index
        // throws ArrayIndexOutOfBoundsException for incorrect index
        if (index >= 0 && index < size) {
            hashMap.put(index, value);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        // returns a value at a given index
        // throws ArrayIndexOutOfBoundsException for incorrect index
        T value = null;
        if (index >= 0 && index < size) {
            if (hashMap.getOrDefault(index, null) == null) {
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
    }
}

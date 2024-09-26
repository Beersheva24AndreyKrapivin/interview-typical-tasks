package telran.interview;

import java.util.*;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two numbers, 
     * summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        boolean res = false;
        Set<Integer> set = new HashSet<>();
        int index = 0;

        while (index < array.length && !res) {
            int result = sum - array[index];
            if (set.contains(result)) {
                res = true;
            } else {
                set.add(array[index]);
            }
            index++;
        }
        
        return res;
    }
}

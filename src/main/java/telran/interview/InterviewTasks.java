package telran.interview;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two numbers,
     *         summing of which gives the value equaled to a given "sum" value
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

    static public int getMaxWithNegativePresentation(int[] array) {
        // returns maximal positive value for which exists negative one with the same
        // abs value
        // if no pair of positive and negative values with the same abs value the method
        // returns -1
        // complexity O[N] only one pass over the elements
        Set<Integer> set = new HashSet<>();
        int res = -1;

        for (int element : array) {
            if (element < 0 && set.contains(-element)) {
                res = Math.max(res, -element);
            } else if (element > 0 && set.contains(-element)) {
                res = Math.max(res, element);
            }
            set.add(element);
        }

        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        // rolesHistory is the list containg dates and roles assigned to the employees
        // at the appropriate dates
        // for example, date => 2019-01-01, role => Developer means that some employee
        // (no matter who) was taken
        // role Developer at 2019-01-01
        // create List<DateRole> with roles matching with the given dates
        // most effective data structure
        List<DateRole> list = new LinkedList<>();
        TreeMap<LocalDate, DateRole> treeMap = new TreeMap<>();

        rolesHistory.forEach(element -> treeMap.put(element.date(), element));

        for (LocalDate date : dates) {
            Map.Entry<LocalDate, DateRole> mapEntry = treeMap.floorEntry(date);
            if (mapEntry == null) {
                list.add(new DateRole(date, null));
            } else {
                list.add(new DateRole(date, mapEntry.getValue().role()));
            }
        }

        return list;
    }

    public static boolean isAnagram(String word, String anagram) {
        // returns true if "anagram" string contains all
        // letters from "word" in another order (case sensitive)
        // O[N] (sorting is disallowed)
        boolean res = false;

        if (word.length() == anagram.length() && !word.equals(anagram)) {
            Map<Character, Integer> map = new HashMap<>();
            char[] wordArray = word.toCharArray();
            char[] anagramArray = anagram.toCharArray();

            for (int i = 0; i < wordArray.length; i++) {
                char charWord = wordArray[i];
                int value = map.getOrDefault(charWord, 0) + 1;
                putRemoveValue(charWord, value, map);

                char charAnagram = anagramArray[i];
                value = map.getOrDefault(charAnagram, 0) - 1;
                putRemoveValue(charAnagram, value, map);
            }

            if (map.isEmpty()) {
                res = true;
            }
        }

        return res;
    }

    private static void putRemoveValue(char simbol, int value, Map<Character, Integer> map) {
        if (value == 0) {
            map.remove(simbol);
        } else {
            map.put(simbol, value);            
        }
    }

}

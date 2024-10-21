package telran.interview;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class AutoCompletion {
    private TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        // adds new word into auto-completion variants
        // returns true if added, false otherwise (if a given word already exists)
        return treeSet.add(word);
    }

    public String[] getVariants(String prefix) {
        // returns all words beginning with a given prefix
        // Complexity of finding the variants is O[logN]
        SortedSet<String> set = treeSet.subSet(prefix, true, prefix + Character.MAX_VALUE, false);

        return set.toArray(new String[0]);
    }
}

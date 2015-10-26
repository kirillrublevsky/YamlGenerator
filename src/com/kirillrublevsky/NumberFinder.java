package com.kirillrublevsky;

import java.util.*;

import static com.kirillrublevsky.Utils.arrayToList;

/**
 * Class NumberFinder contains public static method aimed to find out unique number from the int array and three
 * utility private methods.
 */
public final class NumberFinder {

    /**
     * Don't let anyone instantiate this class.
     */
    private NumberFinder() {}

    /**
     * Returns a unique integer - digit of the array that does not have duplicate. Uses one method from Utils class
     * and two private utility methods. The logic step by step is:
     * 1. Convert an array of ints to List of Integers - this simplifies further process;
     * 2. Create a list of unique Integers, using initial list;
     * 3. Create a list of duplicates - digits that have second instance of the same value;
     * 4. Remove all duplicates from initial list;
     * 5. After all, only one digit is left - the one that does not have duplicate.
     *
     * @param inputArray array of ints to process
     * @return int digit that has only one instance of its value
     */
    public static int getUniqueNumber(int[] inputArray) {
        List<Integer> inputList = arrayToList(inputArray);
        List<Integer> unique = createUniqueList(inputList);
        List<Integer> duplicates = getDuplicates(inputList, unique);

        inputList.removeAll(duplicates);
        return inputList.get(0);
    }

    /**
     * Private utility method. Returns a list of unique digits, parsed from input list. Uses Set<Integer> to reach
     * this goal.
     *
     * @param inputList List of Integers to process
     * @return List<Integer> List of unique integers
     */
    private static List<Integer> createUniqueList(List<Integer> inputList) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputList);
        return new ArrayList<>(uniqueNumbers);
    }

    /**
     * Private utility method. Returns a List of Integers that have two instances of the same value. Uses
     * utility method removeEqualIntegers() to reach that goal. The logic step by step is:
     * 1. Create new List of Integers - technically copy of initial list;
     * 2. Remove all unique Integers from this List using utility method - only numbers that have second instance
     * are left;
     * 3. Doubling this digits - now we have a list of duplicate pairs.
     *
     * @param inputList     List of Integers to process
     * @param uniqueNumbers List of unique Integers
     * @return List<Integer> List of duplicate pairs
     */
    @SuppressWarnings("CollectionAddedToSelf")
    private static List<Integer> getDuplicates(List<Integer> inputList, List<Integer> uniqueNumbers) {
        List<Integer> duplicates = new ArrayList<>(inputList);
        removeEqualIntegers(duplicates, uniqueNumbers);
        duplicates.addAll(duplicates);
        return duplicates;
    }

    /**
     * Private utility method. Removes all elements of second list from first list.
     *
     * @param inputList        List of Integers to remove from
     * @param elementsToRemove List of Integers to remove
     */
    private static void removeEqualIntegers(List<Integer> inputList, List<Integer> elementsToRemove) {
        for (Integer element : elementsToRemove) {
            inputList.remove(element);
        }
    }

}
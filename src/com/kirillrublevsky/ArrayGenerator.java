package com.kirillrublevsky;

import java.util.*;

/**
 * Class ArrayGenerator contains two public static methods - Integer array generator and int generator, and two
 * private utility methods.
 */
public final class ArrayGenerator {

    /**
     * The static instance of Random class used in static methods of the class.
     */
    private static Random random = new Random();

    /**
     * Don't let anyone instantiate this class.
     */
    private ArrayGenerator() {}

    /**
     * Returns an array of Integers with pairs of duplicates and one unique Integer. Uses two private utility
     * methods. The logic step by step is:
     * 1. Create a List of unique Integers;
     * 2. Doubling all Integers in this list;
     * 3. Remove one random Integer from the list;
     * 4. Convert List of Integers to array.
     *
     * @param uniqueNumbersQuantity a number of unique digits
     * @return Integer[] an array of duplicates with only one unique Integer
     */
    @SuppressWarnings("CollectionAddedToSelf")
    public static Integer[] generateRandomArray(int uniqueNumbersQuantity) {
        List<Integer> resultList = generateUniqueNumbers(uniqueNumbersQuantity);
        resultList.addAll(resultList);
        int index = getRandomElement(resultList);
        resultList.remove(index);

        return resultList.toArray(new Integer[resultList.size()]);
    }

    /**
     * Returns a random int from 5 to 9.
     *
     * @return int a random int from 5 to 9
     */
    public static int getUniqueNumbersQuantity() {
        return random.nextInt(5) + 5;
    }

    /**
     * Private utility method. Returns a List of only unique Integers. The logic step by step is:
     * 1. Create top integer for random integer generator, in this case the max integer can be three times bigger
     * than number of unique numbers. E.g. the quantity of numbers is 5 - the max is 15 (excluding);
     * 2. Create a Set of Integers - only unique numbers available;
     * 3. Generate unique Integers - max three times bigger than Set size. The size of Set is equal to initial
     * unique numbers quantity;
     * 4. Convert Set to List.
     *
     * @param uniqueNumbersQuantity a number of unique digits
     * @return List<Integer> a list of unique integers
     */
    private static List<Integer> generateUniqueNumbers(int uniqueNumbersQuantity) {
        Random random = new Random();
        int top = 3 * uniqueNumbersQuantity;
        Set<Integer> uniqueNumbersSet = new HashSet<>();

        while (uniqueNumbersSet.size() != uniqueNumbersQuantity) {
            uniqueNumbersSet.add(random.nextInt(top));
        }

        return new ArrayList<>(uniqueNumbersSet);
    }

    /**
     * Private utility method. Returns a random index of the input list.
     *
     * @param inputList a list of integers to process
     * @return int a random index of input array
     */
    private static int getRandomElement(List<Integer> inputList) {
        return random.nextInt(inputList.size());
    }
}
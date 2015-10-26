package com.kirillrublevsky;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Utils contains utility static methods that convert int array to List and vise versa.
 */
public final class Utils {

    /**
     * Don't let anyone instantiate this class.
     */
    private Utils() {}

    /**
     * Returns int array converted from not parametrized ArrayList. Uses external library of Google Guava.
     *
     * @param inputList the ArrayList without parameters. It is supposed that it is retrieved from YamlReader
     * @return int[] converted from ArrayList<Integer>
     */
    @SuppressWarnings("unchecked")
    public static int[] listToArray(ArrayList inputList) {
        List integerList = Lists.transform(inputList, new Function<String, Integer>() {
            public Integer apply(String e) {
                return Integer.parseInt(e);
            }
        });
        return Ints.toArray(integerList);
    }

    /**
     * Returns List<Integer> converted from int array.
     *
     * @param inputArray the array to convert
     * @return List<Integer> converted from int array
     */
    public static List<Integer> arrayToList(int[] inputArray) {
        List<Integer> list = new ArrayList<>();
        for (int element : inputArray) {
            list.add(element);
        }
        return list;
    }
}
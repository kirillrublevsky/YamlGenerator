package com.kirillrublevsky;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

import static com.kirillrublevsky.ArrayGenerator.generateRandomArray;
import static com.kirillrublevsky.ArrayGenerator.getUniqueNumbersQuantity;
import static com.kirillrublevsky.NumberFinder.getUniqueNumber;
import static com.kirillrublevsky.YamlSerializer.readFromFile;
import static com.kirillrublevsky.YamlSerializer.writeToFile;

/**
 * Class Application contains main() method that runs application.
 */
public final class Application {

    /**
     * Don't let anyone instantiate this class.
     */
    private Application() {}

    /**
     * Runs application. The logic step by step is:
     * 1. Specify the name of the YAML file to write array to;
     * 2. Randomly generate number of unique integers of the array;
     * 3. Generate an array of integer duplicates with one unique integer;
     * 4. Print to console the info about generated array;
     * 5. Write this array to YAML file;
     * 6. Read an array from YAML file;
     * 7. Find unique number and print to console;
     * 8. Catch exceptions.
     */
    public static void main(String[] args) {
        String fileName = "c:\\array.yml";
        try {
            int input = getUniqueNumbersQuantity();
            Integer[] generatedArray = generateRandomArray(input);
            System.out.println("The array of " + (input * 2 - 1) + " integers generated with " + input
                    + " unique digits is: " + Arrays.toString(generatedArray));

            writeToFile(generatedArray, fileName);
            System.out.println("The array is written to YAML file " + fileName + "\n");

            int[] inputArray = readFromFile(fileName);
            System.out.println("The array read from file " + fileName + " is: " + Arrays.toString(inputArray)
                    + "\n" + "The number found only once in the array is: " + getUniqueNumber(inputArray));
        } catch (InputMismatchException | IOException e) {
            e.printStackTrace();
        }
    }
}
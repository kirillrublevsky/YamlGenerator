package com.kirillrublevsky;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.kirillrublevsky.Utils.listToArray;

/**
 * Class YamlSerializer contains static methods that write an array of integers to YAML file and
 * read array back from this file. Uses external library of Yamlbeans.
 */
public final class YamlSerializer {

    /**
     * Don't let anyone instantiate this class.
     */
    private YamlSerializer() {}

    /**
     * Writes an array of Integers to YAML file with specified name.
     *
     * @param inputArray array of Integers to write to the YAML file
     * @param fileName   name of the YAML file to write to
     * @throws IOException
     */
    public static void writeToFile(Integer[] inputArray, String fileName) throws IOException {
        YamlWriter writer = new YamlWriter(new FileWriter(fileName));
        writer.write(inputArray);
        writer.close();
    }

    /**
     * Reads an array of ints from YAML file with specified name. Uses static method from class Utils to convert
     * list to an array.
     *
     * @param fileName name of the YAML file to read from
     * @return int[] array of ints read from the file
     * @throws FileNotFoundException
     * @throws YamlException
     */
    public static int[] readFromFile(String fileName) throws FileNotFoundException, YamlException {
        YamlReader reader = new YamlReader(new FileReader(fileName));
        ArrayList inputList = reader.read(ArrayList.class);
        return listToArray(inputList);
    }
}
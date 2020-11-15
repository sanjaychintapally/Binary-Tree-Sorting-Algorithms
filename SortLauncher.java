package com.company;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class SortLauncher {

    public static int[] convertStringToIntegerArray(String[] string) {
        int[] arr = new int[string.length];

        for(int i = 0; i < string.length; i++)
            arr[i] = Integer.parseInt(string[i]);

        return arr;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/com/company/numbers.properties");
        Properties prop = new Properties();
        prop.load(fis);

        System.out.println(args[0] + " Input Array: " + prop.getProperty(args[0]));

        String[] inputNumber = prop.getProperty(args[0]).split(", ");
        int[] unsortedArray = convertStringToIntegerArray(inputNumber);

        HeapSort heap = new HeapSort();
        heap.sort(unsortedArray);

        unsortedArray = convertStringToIntegerArray(inputNumber);
        TreeSort tree = new TreeSort();
        tree.sort(unsortedArray);
    }
}

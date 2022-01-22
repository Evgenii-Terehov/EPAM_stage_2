package sortedRandomNubers;
/**
1. Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
 */

import exceptions.AnotherSymbolsInsteadOfNumbersException;
import exceptions.UnableToWriteFileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortedRandomNumbers {
    private static final String PATH_TO_FILE = "data\\sorted-random-numbers-data\\output.txt";
    private static final int SIZE_OF_ARRAY = 10;

    public static void main(String[] args) {
        File file = new File(PATH_TO_FILE);
        createFileOfNumbers(Arrays.toString(new Random()
                .ints(SIZE_OF_ARRAY, 0, 100).toArray()));

        int[] array = scanFile(file);
        Arrays.sort(array);
        String sortedNumbers = Arrays.toString(array);
        createFileOfNumbers(sortedNumbers);
    }

    public static void createFileOfNumbers(String arrayOfNumbers) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_FILE)) {

            fileWriter.write(arrayOfNumbers
                    .replaceAll("[\\[\\],]", "")
            );
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new UnableToWriteFileException("Unable to write in the file");
        }
    }

    public static int[] scanFile(File fileToScan) {
        int[] array = new int[SIZE_OF_ARRAY];
        try (Scanner scanner = new Scanner(fileToScan)) {
            for (int i = 0; i < SIZE_OF_ARRAY; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new AnotherSymbolsInsteadOfNumbersException("Array have another symbols instead of numbers");
        }
        return array;
    }
}


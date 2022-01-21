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
    static String pathToFile = "data\\sorted-random-numbers-data\\output.txt";
    static int sizeOfArray = 10;

    public static void main(String[] args) {
        File file = new File(pathToFile);
        createFileOfNumbers(Arrays.toString(new Random()
                .ints(sizeOfArray, 0, 100).toArray()));

        int[] array = scanFile(file);
        Arrays.sort(array);
        String sortedNumbers = Arrays.toString(array);
        createFileOfNumbers(sortedNumbers);
    }

    public static void createFileOfNumbers(String arrayOfNumbers) {
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {

            fileWriter.write(arrayOfNumbers
                    .replaceAll("[\\[\\],]", "")
            );
            fileWriter.write("\n");
        } catch (IOException e) {
            throw new UnableToWriteFileException("Unable to write in the file");
        }
    }

    public static int[] scanFile(File fileToScan) {
        int[] array = new int[sizeOfArray];
        try (Scanner scanner = new Scanner(fileToScan)) {
            for (int i = 0; i < sizeOfArray; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new AnotherSymbolsInsteadOfNumbersException("Array have another symbols instead of numbers");
        }
        return array;
    }
}


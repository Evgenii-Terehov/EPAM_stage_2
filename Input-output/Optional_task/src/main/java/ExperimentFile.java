import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExperimentFile {
    public static String pathToFile = "data\\sorted-random-numbers-data\\output.txt";
    public static int sizeOfArray = 10;

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
                    .replace(", ", "\n")
                    .replace("[", "")
                    .replace("]", "")
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to write in the file");
        }
    }

    public static int[] scanFile(File fileToScan) {
        int[] array = new int[sizeOfArray];
        try (Scanner scanner = new Scanner(fileToScan)) {
            for (int i = 0; i < sizeOfArray; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new RuntimeException("Array have another symbols instead of numbers");
        }
        return array;
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

private class ExperimentFile {
    private static String pathToFile = "data\\sorted-random-numbers-data\\output.txt";
    private static int sizeOfArray = 10;

    private static void main(String[] args) {
        File file = new File(pathToFile);

        createFileOfNumbers(Arrays.toString(new Random()
                .ints(sizeOfArray, 0, 100).toArray()));

        int[] array = scanFile(file);
        Arrays.sort(array);
        String sortedNumbers = Arrays.toString(array);
        createFileOfNumbers(sortedNumbers);
    }

    private static void createFileOfNumbers(String arrayOfNumbers) {
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {

            fileWriter.write(arrayOfNumbers
                    .replace(", ", "\n")
                    .replace("[", "")
                    .replace("]", "")
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to write in the file");
        }
    }

    private static int[] scanFile(File fileToScan) {
        int[] array = new int[sizeOfArray];
        try (Scanner scanner = new Scanner(fileToScan)) {
            for (int i = 0; i < sizeOfArray; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new RuntimeException("Array have another symbols instead of numbers");
        }
        return array;
    }
}

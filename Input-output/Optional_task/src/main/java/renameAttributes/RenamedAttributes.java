package renameAttributes;
/**
 * 2. Прочитать текст Java-программы и все слова public в объявлении
 *    атрибутов и методов класса заменить на слово private
 */

import exceptions.UnableToWriteFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RenamedAttributes {
    private static final String PATH_TO_OUTPUT_FILE = "data\\renamed-attributes-data\\output.txt";
    private static final String PATH_TO_EXPERIMENT_FILE = "src\\main\\java\\ExperimentFile.java";

    static File fileToExperiment = new File(PATH_TO_EXPERIMENT_FILE);
    static File fileToOutput = new File(PATH_TO_OUTPUT_FILE);

    public static void main(String[] args) {
        scanExperimentFile();
        scanOutputFile();
    }

    public static void scanExperimentFile() {
        try (Scanner scanner = new Scanner(fileToExperiment)) {
            while(scanner.hasNextLine()) {
                writeFile(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void scanOutputFile() {
        try (Scanner scannerBack = new Scanner(fileToOutput)) {
            while(scannerBack.hasNextLine()) {
                writeFileBack(scannerBack.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String stringToWrite) {
        try (FileWriter writer = new FileWriter(fileToOutput, true)) {
            writer.write(stringToWrite
                    .replace("public", "private"));
            writer.write("\n");
        } catch (IOException e) {
            throw new UnableToWriteFileException("Unable to write the file");
        }
    }

    public static void writeFileBack(String stringToWrite) {
        try (FileWriter writerBack = new FileWriter(fileToExperiment, true)) {
            writerBack.write(stringToWrite);
            writerBack.write("\n");
        } catch (IOException e) {
            throw new UnableToWriteFileException("Unable to write the file");
        }
    }
}

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
    private final static String pathToOutputFile = "data\\renamed-attributes-data\\output.txt";
    static String pathToExperimentFile = "src\\main\\java\\ExperimentFile.java";//PATH_TO_FILE

    static File fileToExperiment = new File(pathToExperimentFile);//static?
    static File fileToOutput = new File(pathToOutputFile);//static?

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

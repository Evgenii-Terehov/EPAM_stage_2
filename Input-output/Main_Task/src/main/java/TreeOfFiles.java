import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.Scanner;

public class TreeOfFiles {

    static int points = 0;
    static String indentForDirectory = "|---";
    static final String ONE_MORE_INDENT_FOR_DIRECTORY = "--";
    static String indentForFile = "|   ";
    static final String ONE_MORE_INDENT_FOR_FILE = "  ";

    static String forDirectory;
    static String forFile;
    static File pathToFile;
    private static final String PATH_TO_OUTPUT_FILE = "data/outputFile.txt";

    public static void main(String[] args) {
        System.out.println("Please, enter the path: ");

        String enteredPath = (new Scanner(System.in)).nextLine();
        pathToFile = new File(enteredPath);

        if (pathToFile.isDirectory()) {
            File outputFile = new File(PATH_TO_OUTPUT_FILE);
            outputFile.delete();
            parsingDirectory(pathToFile);

        } else {
            File outputFile = new File(PATH_TO_OUTPUT_FILE);
            outputFile.delete();
            parsingDirectory(pathToFile.getParentFile());
            writeInformationAboutDirectory();
        }
    }

    public static void parsingDirectory(File loadDirectory) {
        File[] file = loadDirectory.listFiles();
        StringBuilder stringBuilder = new StringBuilder();

        assert file != null; //неопределенное поведение, проверка аргументов в начале функции
        for (File someInMassive : file) {

            if (someInMassive.isDirectory()) {

                points++;
                indentForDirectory = indentForDirectory.concat(ONE_MORE_INDENT_FOR_DIRECTORY);
                indentForFile = indentForFile.concat(ONE_MORE_INDENT_FOR_FILE);

                forDirectory = String.format("%-1s; %n", indentForDirectory + someInMassive.getName());
                stringBuilder.append(forDirectory);
                writeIntoTheFile(forDirectory);
                parsingDirectory(someInMassive);
            } else {
                if (points == 0) {
                    forFile = String.format("|   %-1s; %n", someInMassive.getName());
                    stringBuilder.append(forFile);
                    writeIntoTheFile(forFile);
                } else {
                    forFile = String.format("%-1s; %n", indentForFile + someInMassive.getName());
                    stringBuilder.append(forFile);
                    writeIntoTheFile(forFile);
                }
            }
        }
        points--;
    }

    public static void writeInformationAboutDirectory() {
        try {
            List<String> inputList = Files.readAllLines(Paths.get(PATH_TO_OUTPUT_FILE));
            double numberOfDirectories = inputList.stream()
                    .filter(directory -> directory.contains("|---")).count();
            double numberOfFiles = inputList.stream()
                    .filter(file -> file.contains("|   ")).count();
            double averageFileNameLength = inputList.stream().filter(files -> files.contains("|   "))
                    .map(elem -> elem.substring(3, elem.lastIndexOf(".")))
                    .mapToInt(String::length)
                    .sum();
            System.out.println("Number of folders: " + numberOfDirectories);
            System.out.println("Number of files: " + numberOfFiles);
            System.out.println("Average files in the directory: " + numberOfDirectories / numberOfFiles);
            System.out.println("Average file name length: " + averageFileNameLength / numberOfFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeIntoTheFile(String string) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_OUTPUT_FILE, true)) {
            fileWriter.write(String.valueOf(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

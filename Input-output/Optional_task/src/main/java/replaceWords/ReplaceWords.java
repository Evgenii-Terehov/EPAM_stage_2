package replaceWords;
/**
 * 10. Прочитать строки из файла и поменять местами первое
 *     и последнее слова в каждой строке.
 */

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    private static final String PATH_TO_OUTPUT_FILE = "data\\replace-words-data\\output.txt";
    private static final String PATH_TO_INPUT_FILE = "data\\replace-words-data\\output.txt";

    public static void main(String[] args) {
        File file = new File(PATH_TO_INPUT_FILE);

        replaceWordsInLines(scanStringLines(file));
    }

    public static List<String> scanStringLines(File inputFile) {
        List<String> inputList = new ArrayList<>();
        try {
            inputList = Files.readAllLines(Paths.get(inputFile.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public static void replaceWordsInLines(List<String> list) {
        for (String line : list) {
            String[] words = line.split(" ");
            String firstWord = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = firstWord;
            String finishedStrings = String.join(" ", words);
            writeIntoTheFile(finishedStrings);
        }
    }

    public static void writeIntoTheFile(String words) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_OUTPUT_FILE, true)) {
            fileWriter.write(String.valueOf(words));
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.epam.tat.encryptor.datasource.impl;

import com.epam.tat.encryptor.datasource.IDataSource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileDataSource implements IDataSource {

    private final String inputEndpoint;
    private final String outputEndpoint;

    public FileDataSource(String inputEndpoint, String outputEndpoint) {
        this.inputEndpoint = inputEndpoint;
        this.outputEndpoint = outputEndpoint;
    }

    @Override
    public void writeData(List<String> data) {
        try (FileWriter fileWriter = new FileWriter(outputEndpoint, true)) {
            for (String stringLine : data) {
                fileWriter.write(String.valueOf(stringLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readData() {
        return readData(inputEndpoint);
    }

    @Override
    public List<String> readData(String path) {
        int[] array = new int[sizeOfArray];
        try (Scanner scanner = new Scanner(path)) {
            for (int i = 0; i < sizeOfArray; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new RuntimeException("Array have another symbols instead of numbers");
        }
    }
}

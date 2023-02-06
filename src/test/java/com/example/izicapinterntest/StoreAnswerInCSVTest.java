package com.example.izicapinterntest;


import com.example.izicapinterntest.services.CSVService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class StoreAnswerInCSVTest {
    private final String path = "answers_test.csv";
    private final String question = "What is the capital of France?";
    private final String answer = "Paris";

    @Before
    public void setUp() throws IOException {
        File file = new File(path);
        file.createNewFile();
    }

    @Test
    public void storeAnswerInCSV_WritesAnswerInCSVFile_WhenValidInputIsGiven() throws IOException {
        CSVService csvService = new CSVService();
        csvService.storeAnswerInCSV(path, question, answer);

        String csvData = readFromCSVFile(path);

        assertEquals(question + ";" + answer + "\n", csvData);
    }

    @After
    public void tearDown() {
        File file = new File(path);
        file.delete();
    }


    private String readFromCSVFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder csvData = new StringBuilder();
        while (scanner.hasNextLine()) {
            csvData.append(scanner.nextLine()).append("\n");
        }

        fileReader.close();
        scanner.close();
        return csvData.toString();
    }
}

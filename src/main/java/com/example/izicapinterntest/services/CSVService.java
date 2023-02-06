package com.example.izicapinterntest.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

@Service
public class CSVService implements CSVServiceInt {
    @Override
    public void storeAnswerInCSV(String path, String question, String answer) {
        try {
            File answersFile = new File(path);

            if (!answersFile.exists()) {
                answersFile.createNewFile();

                FileWriter writer = new FileWriter(answersFile, true);
                writer.write("Question;answer\n");
                writer.close();
            }

            FileWriter writer = new FileWriter(answersFile, true);
            writer.write(question + ";" + answer + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: Unable to store answer in the CSV file." + e.toString());
        }
    }
}

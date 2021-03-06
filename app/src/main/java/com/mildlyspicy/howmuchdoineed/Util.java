package com.mildlyspicy.howmuchdoineed;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

class CsvReadWrite {
    private String baseDir;

    CsvReadWrite(String directory) {
        baseDir = directory;
    }

    void writeCsvToStorage(ArrayList<String[]> arrayToWrite) {
        String[] courseName = arrayToWrite.get(0);
        String[] assignmentNames = arrayToWrite.get(1);
        String[] assignmentWeights = arrayToWrite.get(2);
        String[] grades = arrayToWrite.get(3);

        try {
            System.out.println(baseDir + "/" + courseName[0] + ".csv");
            CSVWriter writer = new CSVWriter(new FileWriter(baseDir + "/" + courseName[0] + ".csv"));

            writer.writeNext(courseName);
            writer.writeNext(assignmentNames);
            writer.writeNext(assignmentWeights);
            writer.writeNext(grades);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<String[]> readCsvFromStorage(String courseName) {
        ArrayList<String[]> arrList = new ArrayList<>();
        try {
            System.out.println(baseDir + "/" + courseName + ".csv");
            CSVReader reader = new CSVReader(new FileReader(baseDir + "/" + courseName + ".csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                arrList.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrList;
    }
}
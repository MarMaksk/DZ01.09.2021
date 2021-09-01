package com.company.task3.operation;

import com.company.task3.UserId;

import java.io.*;

public class FileOperation {
    public static void writeOperation(UserId userId, String userAnswer) {
        File file = new File("operationUser" + userId + ".txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (!file.exists())
                file.createNewFile();
            fileWriter.write(userAnswer + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showOperation(UserId userId) {
        File file = new File("operationUser" + userId + ".txt");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package task3;

import task3.operation.FileOperation;
import task3.operation.MathOperation;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        UserId userId = new UserId(1);
        System.out.println(MathOperation.math(userId, "3 + 8"));
        FileOperation.showOperation(userId);
    }
}


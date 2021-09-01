package com.company.task3;

import com.company.task3.operation.FileOperation;
import com.company.task3.operation.MathOperation;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        UserId userId = new UserId(1);
        System.out.println(MathOperation.math(userId, "3 + 8"));
        FileOperation.showOperation(userId);
    }
}


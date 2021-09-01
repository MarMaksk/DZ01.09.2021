package com.company.task3.operation;

import com.company.task3.UserId;

public class MathOperation {
    public static String math(UserId userId, String operation) {
        String variable = operation;
        String userAnswer = "";
        if (variable.matches("\\d+[ ][+\\-*:][ ]\\d+")) {
            String[] variables = variable.split("[ ]");
            switch (variables[1]) {
                case "+" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) + Integer.valueOf(variables[2]));
                case "-" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) - Integer.valueOf(variables[2]));
                case "*" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) * Integer.valueOf(variables[2]));
                case ":" -> userAnswer = String.valueOf(Integer.valueOf(variables[0]) / Integer.valueOf(variables[2]));
                default -> userAnswer = "Операция не поддерживается";
            }
        } else {
            userAnswer = "Неправильный формат сообщения";
        }
        FileOperation.writeOperation(userId, userAnswer);
        return userAnswer;
    }
}
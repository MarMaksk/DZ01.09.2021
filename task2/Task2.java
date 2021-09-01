package com.company.task2;


import com.company.task2.service.ServiceTask;

public class Task2 {
    public static void main(String[] args) {
        Task task0 = new Task("Sosiski", "Buy sosages", 10, "Me", "11.02.2002", "12.02.2002");
        ServiceTask stf = new ServiceTask();
        stf.saveMethod(task0);
        System.out.println(stf.getListTask());
    }
}

package com.company.task2.service;

import com.company.task2.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTask implements Serializable {
    private List<Task> listTask = new ArrayList<>();

    {
        File file = new File("tasks");
        String[] list = file.list();
        for (String ls : list){
            ls.replace(".dat", "");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks/"+ls))) {
                listTask.add((Task) ois.readObject());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveMethod(Task task) {
        File file = new File("tasks");
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file1 = new File("tasks/Task " + task.getHeading() + ".dat");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file1));) {
            objectOutputStream.writeObject(task);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
}


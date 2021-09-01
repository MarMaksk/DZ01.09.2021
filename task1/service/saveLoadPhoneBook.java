package com.company.task1.service;

import com.company.task1.phoneBook.Contact;
import com.company.task1.phoneBook.PhoneBook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;


public class saveLoadPhoneBook implements Serializable {
    private static final long serialVersionUID = 6529685098262757690L;
    private File file;


    public saveLoadPhoneBook() {
    }

    public void savePhoneBook(PhoneBook phoneBook) throws IOException {

        file = new File(phoneBook.getTableName() + ".dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                PhoneBook pb = (PhoneBook) ois.readObject();
                for (Contact ct : pb.getContacts()) {
                    phoneBook.addContactToBook(ct);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(phoneBook);
        }
    }

    public PhoneBook loadPhoneBook(String tableName) throws IOException {
        file = new File(tableName + ".dat");
        PhoneBook pb;
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return pb = (PhoneBook) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        throw new FileNotFoundException("File not found");
    }
}

package com.company.task1;


import com.company.task1.exception.ContactNotFoundException;
import com.company.task1.phoneBook.Contact;
import com.company.task1.exception.EmailException;
import com.company.task1.exception.NumberException;
import com.company.task1.phoneBook.PhoneBook;
import com.company.task1.service.Service;
import com.company.task1.service.saveLoadPhoneBook;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task1 {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws EmailException, NumberException, ParseException, IOException, ContactNotFoundException {
        PhoneBook pb = new PhoneBook("Book1");
        Contact co = new Contact("Lol", "Mikael", "Forxmail.ru", "Fork@kksdk.ru", sdf.parse("11.11.2011"), pb);
        Contact co1 = new Contact("FRS", "SWAGOWSKI", "kokmail.ru", "Fork@kksdk.ru", sdf.parse("11.11.2011"), pb);
        co.addFax(12345678912L);
        co.addHomeNumber(802121234516l);
        co.addHomeNumber(375297153306l);
        co.addWorkNumber(375297153306l);
        co.addMobileNumber(375297153306l);
        co.addHomeNumber(375297153306l);
        pb.addContactToBook(co);
        pb.addContactToBook(co1);
        Service ser = new Service();
        System.out.println(ser.searchContact(375297153306l, pb));
       // co1.addHomeNumber(375297153306l);
        saveLoadPhoneBook slpb = new saveLoadPhoneBook();
        slpb.savePhoneBook(pb);

    }
}




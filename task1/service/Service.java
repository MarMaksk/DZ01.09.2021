package com.company.task1.service;

import com.company.task1.exception.ContactNotFoundException;
import com.company.task1.phoneBook.Contact;
import com.company.task1.phoneBook.PhoneBook;

import java.util.List;
import java.util.Map;

public class Service {
    public void showContactNames(PhoneBook phoneBook) {
        phoneBook.getContacts().forEach(el -> System.out.println(el.getName()));
    }

    public Contact searchContact(String name, PhoneBook phoneBook) throws ContactNotFoundException {
        for (Contact pb : phoneBook.getContacts())
            if (pb.getName().equals(name))
                return pb;
        throw new ContactNotFoundException("Contact not found");
    }

    public Contact searchContact(Long number, PhoneBook phoneBook) throws ContactNotFoundException {
        for (Contact pb : phoneBook.getContacts())
            for (Map.Entry<String, List<Long>> entry : pb.getContactNumbers().entrySet())
                for (Long ls : entry.getValue())
                    if (ls.equals(number))
                        return pb;
        throw new ContactNotFoundException("Contact not found");
    }
}

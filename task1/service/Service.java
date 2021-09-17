package task1.service;

import task1.exception.ContactNotFoundException;
import task1.phoneBook.Contact;
import task1.phoneBook.PhoneBook;

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
        throw new ContactNotFoundException();
    }

    public Contact searchContact(Long number, PhoneBook phoneBook) throws ContactNotFoundException {
        for (Contact pb : phoneBook.getContacts())
            for (Map.Entry<String, List<Long>> entry : pb.getContactNumbers().entrySet())
                for (Long ls : entry.getValue())
                    if (ls.equals(number))
                        return pb;
        throw new ContactNotFoundException();
    }
}

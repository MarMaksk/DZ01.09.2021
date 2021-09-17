package task1.phoneBook;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook implements Serializable {
    private List<Contact> phoneBook = new LinkedList<>();
    private String tableName;
    private static final long serialVersionUID = 6529685098262757690L;

    public PhoneBook(List<Contact> phoneBook, String tableName) {
        this.phoneBook = phoneBook;
        this.tableName = tableName;
    }

    public PhoneBook(String tableName) {
        this.tableName = tableName;
    }

    public PhoneBook() {
    }

    public void addContactToBook(Contact contact) {
        this.phoneBook.add(contact);
    }

    public List<Contact> getContacts() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

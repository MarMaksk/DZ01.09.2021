package com.company.task1.phoneBook;

import com.company.task1.exception.EmailException;
import com.company.task1.exception.NumberException;

import java.io.Serializable;
import java.util.*;

public class Contact implements Serializable {
    private String name;
    private String surName;
    private String nickname;
    private Map<String, List<Long>> contactNumbers = new HashMap<>();
    private String email;
    private Date dayOfBirthday;
    private PhoneBook phoneBook;
    private List<Long> list = new LinkedList<>();
    private static final long serialVersionUID = 6529685098262757690L;

    private static final String HOME_NUMBER = "HomeNumber";
    private static final String WORK_NUMBER = "WorkNumber";
    private static final String MOBILE_NUMBER = "MobileNumber";
    private static final String FAX = "Fax";
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    {
        this.list.clear();
    }

    public Contact(String name, String surName, String nickname, String email, Date dayOfBirthday, PhoneBook phoneBook) throws EmailException {
        this.name = name;
        this.surName = surName;
        this.nickname = nickname;
        validateEmail(email);
        this.dayOfBirthday = dayOfBirthday;
        this.phoneBook = phoneBook;
    }

    public Contact(String name, String surName, String nickname, String email, PhoneBook phoneBook) throws EmailException {
        this.name = name;
        this.surName = surName;
        this.nickname = nickname;
        validateEmail(email);
        this.phoneBook = phoneBook;
    }

    public Contact(String name, String nickname, String email, Date dayOfBirthday, PhoneBook phoneBook) throws EmailException {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.dayOfBirthday = dayOfBirthday;
        validateEmail(email);
        this.phoneBook = phoneBook;
    }

    public Contact(String name, String surName, PhoneBook phoneBook) {
        this.name = name;
        this.surName = surName;
        this.phoneBook = phoneBook;
    }

    public Contact(String name, PhoneBook phoneBook) {
        this.name = name;
        this.phoneBook = phoneBook;
    }

    public Contact() {
    }

    private void validateEmail(String email) throws EmailException {
        if (email.matches(EMAIL_REGEX))
            this.email = email;
        else
            throw new EmailException("Uncorrect email");
    }

    private List<Long> getListNumber(String typeNumber, Long number, List<Long> list, PhoneBook phoneBook) throws NumberException {
        checkNumberBusy(phoneBook, number);
        if (typeNumber.equals(FAX))
            if (String.valueOf(number).length() != 11)
                throw new NumberException("Uncorrect number fax");
        if (!typeNumber.equals(FAX))
            if (String.valueOf(number).length() != 12)
                throw new NumberException("Uncorrect number phone");
        if (getContactNumbers().get(typeNumber) == null) {
            list.add(number);
        } else {
            list = getContactNumbers().get(typeNumber);
            list.add(number);
        }
        return list;
    }

    private void checkNumberBusy(PhoneBook phoneBook, Long number) throws NumberException {
        for (Contact pb : phoneBook.getContacts())
            for (Map.Entry<String, List<Long>> entry : pb.getContactNumbers().entrySet())
                for (Long ls : entry.getValue())
                    if (ls.equals(number))
                        throw new NumberException("Number busy");

    }

    public void addHomeNumber(Long number) throws NumberException {
        list = getListNumber(HOME_NUMBER, number, list, phoneBook);
        this.contactNumbers.put(HOME_NUMBER, list);
    }

    public void addWorkNumber(Long number) throws NumberException {
        list = getListNumber(WORK_NUMBER, number, list, phoneBook);
        this.contactNumbers.put(WORK_NUMBER, list);
    }

    public void addMobileNumber(Long number) throws NumberException {
        list = getListNumber(MOBILE_NUMBER, number, list, phoneBook);
        this.contactNumbers.put(MOBILE_NUMBER, list);
    }

    public void addFax(Long number) throws NumberException {
        list = getListNumber(FAX, number, list, phoneBook);
        this.contactNumbers.put(FAX, list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Map<String, List<Long>> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(Map<String, List<Long>> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDayOfBirthday() {
        return dayOfBirthday;
    }

    public void setDayOfBirthday(Date dayOfBirthday) {
        this.dayOfBirthday = dayOfBirthday;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", email='" + email + '\'' +
                ", dayOfBirthday=" + dayOfBirthday +
                '}';
    }
}
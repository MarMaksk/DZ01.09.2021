package task1.phoneBook;

import task1.exception.EmailException;
import task1.exception.NumberException;
import task1.exception.RequiredDetailsException;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    {
        this.list.clear();
    }

    public Contact() {
    }

    public static class Builder {
        private Contact newContact;
        private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        public Builder() {
            newContact = new Contact();
        }

        public Builder withName(String name) {
            newContact.name = name;
            return this;
        }

        public Builder withSurName(String surName) {
            newContact.surName = surName;
            return this;
        }

        public Builder withNickname(String nickname) {
            newContact.nickname = nickname;
            return this;
        }

        public Builder withEmail(String email) throws EmailException {
            validateEmail(email);
            return this;
        }

        public Builder withDayOfBirthday(String dayOfBirthday) throws ParseException {
            newContact.dayOfBirthday = sdf.parse(dayOfBirthday);
            return this;
        }

        public Builder withPhoneBook(PhoneBook phoneBook) {
            newContact.phoneBook = phoneBook;
            return this;
        }

        public Contact build() throws RequiredDetailsException {
            Contact contact;
            if (validateContact())
                contact = newContact;
            else
                throw new RequiredDetailsException();
            return contact;
        }

        private boolean validateContact() {
            return (newContact.name != null && newContact.name.trim().length() > 0
                    && newContact.phoneBook != null);
        }

        private void validateEmail(String email) throws EmailException {
            if (email.matches(EMAIL_REGEX))
                newContact.email = email;
            else
                throw new EmailException();
        }

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
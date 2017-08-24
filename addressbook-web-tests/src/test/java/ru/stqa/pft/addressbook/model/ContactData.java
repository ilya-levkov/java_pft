package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactAddress;
    private final String contactMobilePhone;
    private final String contactEmail;
    private String group;

    public ContactData(String contactFirstName, String contactLastName, String contactAddress, String contactMobilePhone, String contactEmail, String group) {
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactAddress = contactAddress;
        this.contactMobilePhone = contactMobilePhone;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getGroup() {
        return group;
    }

}

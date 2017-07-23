package ru.stqa.pft.addressbook;

public class ContactData {
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactAddress;
    private final String contactMobilePhone;
    private final String contactEmail;

    public ContactData(String contactFirstName, String contactLastName, String contactAddress, String contactMobilePhone, String contactEmail) {
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactAddress = contactAddress;
        this.contactMobilePhone = contactMobilePhone;
        this.contactEmail = contactEmail;
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
}

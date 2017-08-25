package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final String contactLastName;
    private final String contactFirstName;
    private final String contactAddress;
    private final String contactMobilePhone;
    private final String contactEmail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactData(int id, String contactLastName, String contactFirstName, String contactAddress, String contactMobilePhone, String contactEmail) {
        this.id = id;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.contactAddress = contactAddress;
        this.contactMobilePhone = contactMobilePhone;
        this.contactEmail = contactEmail;
    }

    public ContactData(String contactLastName, String contactFirstName, String contactAddress, String contactMobilePhone, String contactEmail) {
        this.id = Integer.MAX_VALUE;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.contactAddress = contactAddress;
        this.contactMobilePhone = contactMobilePhone;
        this.contactEmail = contactEmail;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (contactLastName != null ? !contactLastName.equals(that.contactLastName) : that.contactLastName != null)
            return false;
        return contactFirstName != null ? contactFirstName.equals(that.contactFirstName) : that.contactFirstName == null;
    }

    @Override
    public int hashCode() {
        int result = contactLastName != null ? contactLastName.hashCode() : 0;
        result = 31 * result + (contactFirstName != null ? contactFirstName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", contactMobilePhone='" + contactMobilePhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }

}

package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String contactFirstName;
    private String contactLastName;
    private String contactAddress;
    private String contactEmail;
    private String contactHomePhone;
    private String contactMobilePhone;
    private String contactWorkPhone;

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
        return this;
    }

    public ContactData withContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
        return this;
    }

    public ContactData withContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public ContactData withContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }

    public ContactData withContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
        return this;
    }

    public ContactData withContactHomePhone(String contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
        return this;
    }

    public ContactData withContactWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
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

        if (id != that.id) return false;
        if (contactFirstName != null ? !contactFirstName.equals(that.contactFirstName) : that.contactFirstName != null)
            return false;
        return contactLastName != null ? contactLastName.equals(that.contactLastName) : that.contactLastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (contactFirstName != null ? contactFirstName.hashCode() : 0);
        result = 31 * result + (contactLastName != null ? contactLastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                '}';
    }
}

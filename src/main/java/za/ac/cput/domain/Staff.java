//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

public class Staff{
    @Id
    private long staffNumber;
    private long nationalId;
    private String staffName;
    private String staffSurname;

    private Set<Contact> contact;
    private Receptionist receptionist;
    private Manager manager;

    public Staff() {
    }

    public Staff(Builder builder) {
        this.staffNumber = builder.staffNumber;
        this.nationalId = builder.nationalId;
        this.staffName = builder.staffName;
        this.staffSurname =builder.staffSurname;
        this.contact = builder.contact;
        this.receptionist =builder.receptionist;
        this.manager = builder.manager;
    }

    public long getStaffNumber() {
        return staffNumber;
    }

    public long getNationalId() {
        return nationalId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public Set<Contact> getContact() {
        return contact;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffNumber == staff.staffNumber && nationalId == staff.nationalId && Objects.equals(staffName, staff.staffName) && Objects.equals(staffSurname, staff.staffSurname) && Objects.equals(contact, staff.contact) && Objects.equals(receptionist, staff.receptionist) && Objects.equals(manager, staff.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNumber, nationalId, staffName, staffSurname, contact, receptionist, manager);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNumber=" + staffNumber +
                ", nationalId=" + nationalId +
                ", staffName='" + staffName + '\'' +
                ", staffSurname='" + staffSurname + '\'' +
                ", contact=" + contact +
                ", receptionist=" + receptionist +
                ", manager=" + manager +
                '}';
    }
    public static class Builder{
        private int staffNumber;
        private int nationalId;
        private String staffName;
        private String staffSurname;

        private Set<Contact> contact;
        private Receptionist receptionist;
        private Manager manager;

        public Builder setStaffNumber(int staffNumber) {
            this.staffNumber = staffNumber;
            return this;
        }

        public Builder setNationalId(int nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public Builder setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Builder setStaffSurname(String staffSurname) {
            this.staffSurname = staffSurname;
            return this;
        }

        public Builder setContact(Set<Contact> contact) {
            this.contact = contact;
            return this;
        }

        public Builder setReceptionist(Receptionist receptionist) {
            this.receptionist = receptionist;
            return this;
        }

        public Builder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }
        public Builder copy(Builder builder){
            this.staffNumber = builder.staffNumber;
            this.nationalId = builder.nationalId;
            this.staffName = builder.staffName;
            this.staffSurname =builder.staffSurname;
            this.contact = builder.contact;
            this.receptionist =builder.receptionist;
            this.manager = builder.manager;
            return this;

        }
        public Staff build() {
            return new Staff(this);
        }
    }
}


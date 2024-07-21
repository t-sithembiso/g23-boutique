//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
@Entity
public class Staff{
    @Id
    private long staffNumber;
    private long nationalId;
    private String staffName;
    private String staffSurname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name ="email")
    private Contact contact;

    protected Staff() {
    }

    private Staff(Builder builder) {
        this.staffNumber = builder.staffNumber;
        this.nationalId = builder.nationalId;
        this.staffName = builder.staffName;
        this.staffSurname =builder.staffSurname;
        this.contact = builder.contact;
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

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff staff)) return false;
        return getStaffNumber() == staff.getStaffNumber() && getNationalId() == staff.getNationalId() && Objects.equals(getStaffName(), staff.getStaffName()) && Objects.equals(getStaffSurname(), staff.getStaffSurname()) && Objects.equals(getContact(), staff.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStaffNumber(), getNationalId(), getStaffName(), getStaffSurname(), getContact());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNumber=" + staffNumber +
                ", nationalId=" + nationalId +
                ", staffName='" + staffName + '\'' +
                ", staffSurname='" + staffSurname + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private int staffNumber;
        private int nationalId;
        private String staffName;
        private String staffSurname;

        private Contact contact;

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

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }


        public Builder copy(Builder builder){
            this.staffNumber = builder.staffNumber;
            this.nationalId = builder.nationalId;
            this.staffName = builder.staffName;
            this.staffSurname =builder.staffSurname;
            this.contact = builder.contact;
            return this;

        }
        public Staff build() {
            return new Staff(this);
        }
    }
}


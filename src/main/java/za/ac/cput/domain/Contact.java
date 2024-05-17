//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Contact {
    @Id
    private String mobile;
    private String email;
    private Staff staff;

    public Contact() {
    }

    public Contact(Builder builder) {
        this.mobile = builder.mobile;
        this.email = builder.email;
        this.staff = builder.staff;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(mobile, contact.mobile) && Objects.equals(email, contact.email) && Objects.equals(staff, contact.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobile, email, staff);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", staff=" + staff +
                '}';
    }
    public static class Builder{
        private String mobile;
        private String email;
        private Staff staff;

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setStaff(Staff staff) {
            this.staff = staff;
            return this;
        }
        public Builder copy(Builder builder){
            this.mobile = builder.mobile;
            this.email = builder.email;
            this.staff = builder.staff;
            return this;
        }
        public Contact build() {
            return new Contact(this);
        }
    }
}
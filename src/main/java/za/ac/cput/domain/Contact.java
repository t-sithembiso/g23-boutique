//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Contact {
    @Id
    private String mobile;
    private String email;

    public Contact() {
    }

    public Contact(Builder builder) {
        this.mobile = builder.mobile;
        this.email = builder.email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getMobile(), contact.getMobile()) && Objects.equals(getEmail(), contact.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMobile(), getEmail());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private String mobile;
        private String email;
        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Builder builder){
            this.mobile = builder.mobile;
            this.email = builder.email;
            return this;
        }
        public Contact build() {
            return new Contact(this);
        }
    }
}
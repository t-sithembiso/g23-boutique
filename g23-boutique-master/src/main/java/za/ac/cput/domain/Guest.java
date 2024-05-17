package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long guestId;
    String name;
    String email;
    String phone;

    protected Guest() {
    }

    Guest(Builder builder) {
        this.guestId = builder.guestId;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;

    }


    public Long getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(guestId, guest.guestId) && Objects.equals(name, guest.name) && Objects.equals(email, guest.email) && Objects.equals(phone, guest.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, name, email, phone);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


    public static class Builder {
        Long guestId;
        String name;
        String email;
        String phone;

        public Builder setGuestId(Long guestId) {
            this.guestId = guestId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder copy(Guest guest) {
            this.guestId = guest.guestId;
            this.name = guest.name;
            this.email = guest.email;
            this.phone = guest.phone;
            return this;
        }

        public Guest build() {
            return new Guest(this);
        }
    }


}



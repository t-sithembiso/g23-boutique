//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

public class Receptionist {

    @Id
    private long receptionist_id;
    private String username;
    private String password;
    private Set<Staff> staff;

    public Receptionist() {
    }

    public Receptionist(Builder builder) {
        this.receptionist_id = builder.receptionist_id;
        this.username = builder.username;
        this.password = builder.password;
        this.staff = builder.staff;
    }

    public long getReceptionist_id() {
        return receptionist_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receptionist that = (Receptionist) o;
        return receptionist_id == that.receptionist_id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(staff, that.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receptionist_id, username, password, staff);
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "receptionist_id=" + receptionist_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", staff=" + staff +
                '}';
    }
    public static class Builder{
        private int receptionist_id;
        private String username;
        private String password;
        private Set<Staff> staff;

        public Builder setReceptionist_id(int receptionist_id) {
            this.receptionist_id = receptionist_id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setStaff(Set<Staff> staff) {
            this.staff = staff;
            return this;
        }
        public Builder copy(Builder builder){
            this.receptionist_id = builder.receptionist_id;
            this.username = builder.username;
            this.password = builder.password;
            this.staff = builder.staff;
            return this;
        }
        public Receptionist build() {
            return new Receptionist(this);
        }
    }
}

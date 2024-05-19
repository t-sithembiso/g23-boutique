//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
@Entity
public class Manager {
    @Id
    private long managerId;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name ="appointedmanager")
    private Staff staff;

    public Manager() {
    }

    public Manager(Builder builder) {
        this.managerId = builder.managerId;
        this.username = builder.username;
        this.password = builder.password;
        this.staff = builder.staff;
    }

    public long getManagerId() {
        return managerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        return getManagerId() == manager.getManagerId() && Objects.equals(getUsername(), manager.getUsername()) && Objects.equals(getPassword(), manager.getPassword()) && Objects.equals(getStaff(), manager.getStaff());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManagerId(), getUsername(), getPassword(), getStaff());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", staff=" + staff +
                '}';
    }

    public static class Builder{
        private int managerId;
        private String username;
        private String password;
        private Staff staff;

        public Builder setManagerId(int managerId) {
            this.managerId = managerId;
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

        public Builder setStaff(Staff staff) {
            this.staff = staff;
            return this;
        }
        public Builder copy(Builder builder){
            this.managerId = builder.managerId;
            this.username = builder.username;
            this.password = builder.password;
            this.staff = builder.staff;
            return this;
        }
        public Manager build() {
            return new Manager(this);
        }
    }
}

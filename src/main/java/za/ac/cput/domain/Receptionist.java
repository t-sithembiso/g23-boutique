//https://github.com/sitgi/g23-boutique
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
@Entity
public class Receptionist {
    @Id
    private long receptionistId;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name ="appointedReceptionist")
    private Staff staff;

    public Receptionist() {
    }

    public Receptionist(Builder builder) {
        this.receptionistId = builder.receptionistId;
        this.username = builder.username;
        this.password = builder.password;
        this.staff = builder.staff;
    }

    public long getReceptionistId() {
        return receptionistId;
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
        if (!(o instanceof Receptionist that)) return false;
        return getReceptionistId() == that.getReceptionistId() && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getStaff(), that.getStaff());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceptionistId(), getUsername(), getPassword(), getStaff());
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "receptionistId=" + receptionistId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", staff=" + staff +
                '}';
    }

    public static class Builder{
        private int receptionistId;
        private String username;
        private String password;
        private Staff staff;

        public Builder setReceptionist_id(int receptionistId) {
            this.receptionistId = receptionistId;
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
            this.receptionistId = builder.receptionistId;
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

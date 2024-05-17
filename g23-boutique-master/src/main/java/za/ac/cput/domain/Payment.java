package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymenId;
    private Double amount;
    private LocalDate date;
    private long guestId;

    protected Payment(){}
    private Payment(Builder builder){
        this.paymenId = builder.paymentId;
        this.amount = builder.amount;
        this.date = builder.date;
        this.guestId = builder.guestId;
    }

    public long getPaymenId() {return paymenId;}

    public Double getAmount() {return amount;}

    public LocalDate getDate() {return date;}

    public long getGuestId() {return guestId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return guestId == payment.guestId && Objects.equals(paymenId, payment.paymenId) && Objects.equals(amount, payment.amount) && Objects.equals(date, payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymenId, amount, date, guestId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymenId=" + paymenId +
                ", amount=" + amount +
                ", date=" + date +
                ", guestId=" + guestId +
                '}';
    }

    public static class Builder{
        private long paymentId;
        private Double amount;
        private LocalDate date;
        private long guestId;

        public Builder setPaymentId(long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(long amount) {
            this.amount = (double) amount;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setGuestId(long guestId) {
            this.guestId = guestId;
            return this;
        }

        public Payment.Builder copy(Payment payment){
            this.paymentId = payment.paymenId;
            this.amount = payment.amount;
            this.date = payment.date;
            this.guestId = payment.guestId;
            return this;
        }
        public Payment build(){return new Payment(this);}
    }
}




package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    private Long paymentId;
    private double totalAmount;
    private String paymentDescription;
    private LocalDate paymentDate;

    @ManyToOne
    @JoinTable(name = "booking_id")
    private Booking booking;

    protected Payment(){

    }

    private Payment(Builder builder){
        this.paymentId = builder.paymentId;
        this.totalAmount = builder.totalAmount;
        this.paymentDescription = builder.paymentDescription;
        this.paymentDate = builder.paymentDate;
        this.booking = builder.booking;

    }

    public Long getPaymentId() {
        return paymentId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Double.compare(getTotalAmount(), payment.getTotalAmount()) == 0 && Objects.equals(getPaymentId(), payment.getPaymentId()) && Objects.equals(getPaymentDescription(), payment.getPaymentDescription()) && Objects.equals(getPaymentDate(), payment.getPaymentDate()) && Objects.equals(getBooking(), payment.getBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getTotalAmount(), getPaymentDescription(), getPaymentDate(), getBooking());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", totalAmount=" + totalAmount +
                ", paymentDescription='" + paymentDescription + '\'' +
                ", paymentDate=" + paymentDate +
                ", booking=" + booking +
                '}';
    }

    public class Builder{
        private Long paymentId;
        private double totalAmount;
        private String paymentDescription;
        private LocalDate paymentDate;
        private Booking booking;
        private Booking Booking;

        public Builder setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setPaymentDescription(String paymentDescription) {
            this.paymentDescription = paymentDescription;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setContact(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Payment.Builder copy(Payment payment){
            this.paymentId = payment.paymentId;
            this.totalAmount = payment.totalAmount;
            this.paymentDescription = payment.paymentDescription;
            this.paymentDate = payment.paymentDate;
            this.Booking = payment.booking;
            return this;
        }
    }
}

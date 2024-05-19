package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    private Long paymentId;
    private double totalAmount;
    private String paymentDescription;
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;



}

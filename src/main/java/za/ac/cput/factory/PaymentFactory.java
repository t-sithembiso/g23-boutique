package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {
    public static Payment buildPayment(long paymentId, double totalAmount, String paymentDescription, LocalDate paymentDate, Booking booking){
        if(paymentId ==0L || totalAmount ==0.0  || Helper.isNullorEmpty(paymentDescription)
            || paymentDate == null || booking == null)
            return null;

        return new Payment.Builder().setPaymentId(paymentId)
                .setTotalAmount(totalAmount)
                .setPaymentDescription(paymentDescription)
                .setPaymentDate(paymentDate)
                .setBooking(booking)
                .build();
    }
}

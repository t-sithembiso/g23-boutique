package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {
    public static Payment buildPayment(long paymentId, long amount, LocalDate date, long guestId){
        if(paymentId < 0
        || Helper.isNullorEmpty(amount)
        || date == null
        || Helper.isNullorEmpty(guestId))
            return null;

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setAmount(amount)
                .setDate(date)
                .setGuestId(guestId)
                .build();
    }
}

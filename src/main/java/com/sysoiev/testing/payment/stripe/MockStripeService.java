package com.sysoiev.testing.payment.stripe;

import com.sysoiev.testing.payment.CardPaymentCharge;
import com.sysoiev.testing.payment.CardPaymentCharger;
import com.sysoiev.testing.payment.Currency;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@ConditionalOnProperty(
        value = "stripe.enabled",
        havingValue = "false"
)
public class MockStripeService implements CardPaymentCharger {
    @Override
    public CardPaymentCharge chargeCard(String cardSource,
                                        BigDecimal amount,
                                        Currency currency,
                                        String description) {
        return new CardPaymentCharge(true);
    }
}

package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public class VisaCard extends BaseCard {
    private int cashback;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.cashback = cashback;
    }

    @Override
    public boolean checkCardLimitTransfer(double amountForTransfer) {
        if (amountForTransfer > Constants.LIMIT_VISA_CARD) {
            //System.out.println("The card transfer limit has been exceeded.");
            return false;
        } else {
            //System.out.println("The limit has not been exceeded.");
            return true;
            // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит +
            // это пока стоит как ответ-заглушка
        }
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }
}

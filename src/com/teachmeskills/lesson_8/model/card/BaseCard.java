package com.teachmeskills.lesson_8.model.card;

import java.util.Date;

public abstract class BaseCard {
    private String cardNumber;
    private int cvv;
    private Date validDate;
    private String cardHolder;
    private String currency;
    private double amount;

    public BaseCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than 0.");
        }
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.validDate = validDate;
        this.cardHolder = cardHolder;
        this.currency = currency;
        this.amount = amount;
    }


    // TODO добавить в метод входной параметр "сумма для трансфера" +

    /**
     *  Метод проверки лимита карты перед переводом +
     *  Метод должен проверять превышает ли сумма перевода лимит для карты +
     *  Для каждой карты должна быть своя реализиция с проверкой лимитов в соотвествии с типом карты +
     *
     * @return  true - если сумма перевода укладывается в лимиты +
     *          false - если сумма перевода больше лимита для карты +
     */
    public abstract boolean checkCardLimitTransfer(double amountForTransfer);

    public void showBaseInfo(){
        System.out.println(cardNumber + "->" + amount + "->" + validDate);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

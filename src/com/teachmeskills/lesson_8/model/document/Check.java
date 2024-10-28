package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран

public class Check {
    double transferAmount;
    Date dateTransfer;
    String cardNumber;

    public Check(String cardNumber, Date dateTransfer, double transferAmount) {
        this.cardNumber = cardNumber;
        this.dateTransfer = dateTransfer;
        this.transferAmount = transferAmount;
    }

    public void displayCheck(double transferAmount, Date dateTransfer, String cardNumber){
        System.out.println("Check date: " + dateTransfer+ ".\n Card number: " +
                cardNumber + ".\n Amount transfer: " + transferAmount);
    }
}

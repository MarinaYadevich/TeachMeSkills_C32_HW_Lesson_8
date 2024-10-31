package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты +
// TODO создать метод для вывода информации о чеке на экран +

public class Check {
    public double transferAmount;
    public Date dateTransfer;
    String fromNumber;
    String toNumber;
    String comment;

    public Check(double transferAmount, String fromNumber, String toNumber, Date dateTransfer, String comment) {
        this.transferAmount = transferAmount;
        this.toNumber = toNumber;
        this.fromNumber = fromNumber;
        this.dateTransfer = dateTransfer;
        this.comment = comment;
    }

    public void showCheckInfo(){
        System.out.println("Сумма перевода: " + this.transferAmount + ". Дата перевода: " + this.dateTransfer +
                ", c " + this.fromNumber + ", на " + this.toNumber + ". Комментарий: " + this.comment);
    }
}

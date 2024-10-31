package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты +
// TODO создать метод для вывода информации о чеке на экран +

public class Check {
    private double transferAmount;
    private Date dateTransfer;
    private String fromNumber;
    private String toNumber;
    private String comment;

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

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package com.teachmeskills.lesson_8.model.document;

// TODO добавить поля на свое усмотрение +

public class Invoice {
   private int invoiceDate;
   private double invoiceAmount;
   private String sender;

    public int getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(int invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

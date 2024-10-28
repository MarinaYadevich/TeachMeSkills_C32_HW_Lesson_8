package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.transfer.CardTransferService;

// TODO реализовать имплементацию интерфейса

public class MasterCardTransferService implements CardTransferService {

    @Override
    public void transferFromCardToCard(BaseCard cardSender, BaseCard cardRecipient, double amountTransfer) {
        if (cardSender.checkCardLimitTransfer(amountTransfer)) {
            cardSender.amount -= amountTransfer;
            cardRecipient.amount += amountTransfer;
            System.out.println("The transfer was successful.");
        } else {
            System.out.println("Limit exceeded.");
        }
    }

    @Override
    public void transferFromCardToAccount(BaseCard cardSender, Account receivingAccount, double amountTransfer) {
        if (cardSender.checkCardLimitTransfer(amountTransfer)) {
            cardSender.amount -= amountTransfer;
            receivingAccount.amount += amountTransfer;
            System.out.println("The transfer was successful.");
        }else {
            System.out.println("Limit exceeded.");
        }
    }

    @Override
    public void transferFromAccountToAccount(Account senderAccountNumber, Account receivingAccountNumber, double amountTransfer) {
        if(senderAccountNumber.checkAccountLimitTransfer(amountTransfer)){
            senderAccountNumber.amount -= amountTransfer;
            receivingAccountNumber.amount += amountTransfer;
            System.out.println("The transfer was successful.");
        }else{
            System.out.println("Limit exceeded.");
        }
    }
}



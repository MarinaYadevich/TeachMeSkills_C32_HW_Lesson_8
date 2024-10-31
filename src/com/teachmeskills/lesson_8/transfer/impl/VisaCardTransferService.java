package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

// TODO реализовать имплементацию интерфейса +

public class VisaCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard cardSender, BaseCard cardRecipient, double amountTransfer) {
        if(cardSender.amount >= amountTransfer){
            if(amountTransfer > 0){
                if (cardSender.checkCardLimitTransfer(amountTransfer)) {
                    cardSender.amount -= amountTransfer;
                    cardRecipient.amount += amountTransfer;
                    return new Check(amountTransfer, cardSender.cardNumber, cardRecipient.cardNumber,
                            new Date(), "Success.");
                } else {
                    return new Check(amountTransfer, cardSender.cardNumber, cardRecipient.cardNumber, new Date(),
                            "Limits have been exceeded. The transfer limit for this card is: " + Constants.LIMIT_VISA_CARD);
                }
            }else{
                return new Check(amountTransfer, cardSender.cardNumber, cardRecipient.cardNumber, new Date(),
                        "Incorrect value");
            }
        }else {
            return new Check(amountTransfer, cardSender.cardNumber, cardRecipient.cardNumber, new Date(),
                    "Insufficient funds on the card.");
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard cardSender, Account receivingAccount, double amountTransfer) {
        if(cardSender.amount >= amountTransfer){
            if(amountTransfer > 0){
                if (cardSender.checkCardLimitTransfer(amountTransfer)) {
                    cardSender.amount -= amountTransfer;
                    receivingAccount.amount += amountTransfer;
                    return new Check(amountTransfer, cardSender.cardNumber, receivingAccount.accountNumber, new Date(), "Success.");
                } else {
                    return new Check(amountTransfer, cardSender.cardNumber, receivingAccount.accountNumber, new Date(),
                            "Limits have been exceeded. The transfer limit for this card is: " + Constants.LIMIT_VISA_CARD);
                }
            }else{
                return new Check(amountTransfer, cardSender.cardNumber, receivingAccount.accountNumber, new Date(),
                        "Incorrect value.");
            }
        }else {
            return new Check(amountTransfer, cardSender.cardNumber, receivingAccount.accountNumber, new Date(),
                    "Insufficient funds on the card.");
        }
    }
}


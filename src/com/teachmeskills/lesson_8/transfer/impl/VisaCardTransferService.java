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
        if(cardSender.getAmount() >= amountTransfer){
            if(amountTransfer > 0){
                if (cardSender.checkCardLimitTransfer(amountTransfer)) {
                    cardSender.setAmount(cardSender.getAmount() - amountTransfer);
                    cardRecipient.setAmount(cardRecipient.getAmount() - amountTransfer);
//                    cardSender.amount -= amountTransfer;
//                    cardRecipient.amount += amountTransfer;
                    return new Check(amountTransfer, cardSender.getCardNumber(), cardRecipient.getCardNumber(),
                            new Date(), "Success.");
                } else {
                    return new Check(amountTransfer, cardSender.getCardNumber(), cardRecipient.getCardNumber(), new Date(),
                            "Limits have been exceeded. The transfer limit for this card is: " + Constants.LIMIT_VISA_CARD);
                }
            }else{
                return new Check(amountTransfer, cardSender.getCardNumber(), cardRecipient.getCardNumber(), new Date(),
                        "Incorrect value");
            }
        }else {
            return new Check(amountTransfer, cardSender.getCardNumber(), cardRecipient.getCardNumber(), new Date(),
                    "Insufficient funds on the card.");
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard cardSender, Account receivingAccount, double amountTransfer) {
        if(cardSender.getAmount() >= amountTransfer){
            if(amountTransfer > 0){
                if (cardSender.checkCardLimitTransfer(amountTransfer)) {
                    cardSender.setAmount(cardSender.getAmount() - amountTransfer);
                    receivingAccount.setAmount(receivingAccount.getAmount() - amountTransfer);
//                    cardSender.amount -= amountTransfer;
//                    receivingAccount.amount += amountTransfer;
                    return new Check(amountTransfer, cardSender.getCardNumber(), receivingAccount.getAccountNumber(),
                            new Date(), "Success.");
                } else {
                    return new Check(amountTransfer, cardSender.getCardNumber(), receivingAccount.getAccountNumber(), new Date(),
                            "Limits have been exceeded. The transfer limit for this card is: " + Constants.LIMIT_VISA_CARD);
                }
            }else{
                return new Check(amountTransfer, cardSender.getCardNumber(), receivingAccount.getAccountNumber(), new Date(),
                        "Incorrect value.");
            }
        }else {
            return new Check(amountTransfer, cardSender.getCardNumber(), receivingAccount.getAccountNumber(), new Date(),
                    "Insufficient funds on the card.");
        }
    }
}


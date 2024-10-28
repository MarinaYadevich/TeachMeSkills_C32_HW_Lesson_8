package com.teachmeskills.lesson_8.transfer;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;

public interface CardTransferService {

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с..., карта на..., сумма трансфера

    void transferFromCardToCard(BaseCard cardSender, BaseCard cardRecipient, double amountTransfer);

    // TODO сделать возвращаемое значение Check (класс лежит в пакете document)
    // TODO добавить входные параметры в метод: карта с.., счет на..., сумма трансфера
    void transferFromCardToAccount(BaseCard cardSender, Account receivingAccountNumber, double amountTransfer);

    void transferFromAccountToAccount(Account senderAccountNumber, Account receivingAccountNumber, double amountTransfer);


}

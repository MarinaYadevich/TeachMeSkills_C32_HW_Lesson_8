package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;

import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Specify the path to the file: ");
        String path = sc.nextLine();
        sc.close();

        // TODO запросить с консоли путь и имя файла

        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        ParserFabric parserFabric = new ParserFabric(); // не поняла как избавиться от необходимости создания обьекта
        // TODO заменить "" на имя файла, полученное со сканера
        IParser parser = parserFabric.createParser(path);
        parser.parseFile(path);
        System.out.println();

        // TODO реализовать тестовый сценарий
        IndividualClient client1 = new IndividualClient();
        LegalClient client2 = new LegalClient();
        Account accountFirstClient1 = new Account("45676444", 2000);
        Account accountSecondClient1 = new Account("78676490", 3000);
        MasterCard masterCardClient1 = new MasterCard("26463738",345, new Date(),
                "Ivanov", "EUR", "Belarus" );
        VisaCard visaCardClient1 = new VisaCard("90463721",908, new Date(),
                "Ivanov", "BYN", 5);

        Account accountFirstClient2 = new Account("5567564567", 1000);
        Account accountSecondClient2 = new Account("75673456873", 7000);
        MasterCard masterCardClient2 = new MasterCard("745674567",123, new Date(),
                "Yadevich", "EUR", "Belarus" );
        VisaCard visaCardClient2 = new VisaCard("74863478658",111, new Date(),
                "Yadevich", "BYN", 5);

        MasterCardTransferService masterCardTransferService = new MasterCardTransferService(); // создала обьект класса где находится метод
        masterCardTransferService.transferFromCardToCard(masterCardClient1, masterCardClient2, 50);
        System.out.println();

        VisaCardTransferService visaCardTransferService = new VisaCardTransferService();
        visaCardTransferService.transferFromCardToAccount(visaCardClient2, accountSecondClient1, 1000);
        System.out.println();

        Check check = new Check("43765376", new Date(), 50);
        check.displayCheck(50,new Date(), "43738438");
        System.out.println();

        visaCardTransferService.transferFromAccountToAccount(accountFirstClient1, accountSecondClient2, 20000);
        masterCardClient1.showBaseInfo();

        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        // перевести с карты одного клиента на карту другого сумму денег
        // перевести с карты одного клиента на счет другого клиента сумму денег
    }
}

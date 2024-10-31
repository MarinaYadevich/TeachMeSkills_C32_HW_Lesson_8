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

        // TODO запросить с консоли путь и имя файла +
        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric +
        IParser parser = ParserFabric.createParser(path);
        // TODO заменить "" на имя файла, полученное со сканера +
        parser.parseFile(path);
        System.out.println();

        // TODO реализовать тестовый сценарий +
        IndividualClient client1 = new IndividualClient();
        LegalClient client2 = new LegalClient();
        Account accountFirstClient1 = new Account("45676444", 2000);
        Account accountSecondClient1 = new Account("78676490", 3000);
        MasterCard masterCardClient1 = new MasterCard("26463738",345, new Date(),
                "Ivanov", "EUR", 300, "Belarus" );
        VisaCard visaCardClient1 = new VisaCard("274637864578", 384, new Date(),
                "Yaroshenko", "BYN", 0, 5);

        Account accountFirstClient2 = new Account("5567564567", 1000);
        Account accountSecondClient2 = new Account("75673456873", 7000);
        MasterCard masterCardClient2 = new MasterCard("745674567",123, new Date(),
                "Yadevich", "EUR", 500,"Belarus" );
        VisaCard visaCardClient2 = new VisaCard("357545894", 907, new Date(),
                "Kylaga","BYN", 800, 9 );


        MasterCardTransferService masterCardTransferService = new MasterCardTransferService(); // создала обьект класса где находится метод
        Check resultCheck1 = masterCardTransferService.transferFromCardToCard(masterCardClient1, masterCardClient2, 50);
        resultCheck1.showCheckInfo();
        System.out.println("---------");
        System.out.println(masterCardClient1.getAmount());
        System.out.println(masterCardClient2.getAmount());
        System.out.println();

        VisaCardTransferService visaCardTransferService = new VisaCardTransferService();
        Check resultCheck2 = visaCardTransferService.transferFromCardToAccount(visaCardClient2, accountSecondClient1, 1000);
        resultCheck2.showCheckInfo();
        System.out.println("-------");
        System.out.println(visaCardClient2.getAmount());
        System.out.println(accountFirstClient1.getAmount());

        // создать двух клиентов +
        // каждому клиенту создать два счета и две карты +
        // перевести с карты одного клиента на карту другого сумму денег +
        // перевести с карты одного клиента на счет другого клиента сумму денег +
    }
}

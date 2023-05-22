package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Ui {
    public static void runApp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("| Введите данные в произвольном порядке разделяя их пробелами  |");
        System.out.println("| фамилия, имя, отчество. Дата рождения в формате: dd.mm.yyyy  |");
        System.out.println("| номер телефона - число(10 цифр без +7). Например: 9021472536 |");
        System.out.println("| пол - символ латиницей f или m                               |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.print(":> ");
        String data = sc.nextLine();
        String[] dataArray = DataParser.parseData(data);
        try {
            if (FullDataInArray.fullDataInput(dataArray)) {
                String outData = OutDataBuilder.outDataCreate(dataArray);
                DataInFileWriter.dataWriter(outData, dataArray[0]);
            } else {
                throw new RuntimeException("Не все данные введены корректно!");
            }
        } catch (RuntimeException re) {
            System.out.println("\n" + re.getMessage());
            System.out.println("Вы ввели следующие данные:");
            System.out.println(data);
            System.out.println("\nУдалось получить следующие данные:");
            System.out.println(Arrays.toString(dataArray));
            System.out.println("\nДля повторного ввода данных введите 1 : ");
            int yesNo = sc.nextInt();
            if (yesNo == 1) {
                runApp();
            } else {
                System.exit(0);
            }
        }
    }
}

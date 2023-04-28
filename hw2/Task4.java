import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        inputString();
    }

    public static void inputString() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите строку: ");
            String str = sc.nextLine();
            if (str.length() == 0) {
                throw new RuntimeException ("Пустые строки вводить нельзя");
            }
            System.out.println(str);
        } catch (RuntimeException rtex) {
            System.out.println(rtex);
        }
    }
}

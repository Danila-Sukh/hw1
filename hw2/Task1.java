import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        inputFloat();
    }
    public static void inputFloat() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите дробное число\nНапример 3,1415: ");
            float n = sc.nextFloat();
            System.out.println(n);
        } catch (Exception ex) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                    "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" +
                    "\nВы ошиблись при вводе!" +
                    "\nНужно ввести дробное число\nНапример: 3,1415" +
                    "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            inputFloat();
        }
    }
}

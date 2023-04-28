import org.w3c.dom.TypeInfo;
public class Task1 {
    public static void main(String[] args) {
        try {
            System.out.println("Ответ1: " + method1(1) + " (Нет исключений)");
            System.out.println(method1(-1));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            System.out.println("Ответ2: " + method2('y') + " (Нет исключений)");
            System.out.println(method2('v'));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            System.out.println("Ответ3: " + method3(1f) + " (Нет исключений)");
            System.out.println(method3(1d));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static int method1(int args) {
        if (args <= 0) {
            throw new RuntimeException("Первое исключение");
        }
        return 1;
    }

    private static int method2(char args) {
        char[] charArray = {'y', 'Y', 'n', 'N'};
        if ((new String(charArray).indexOf(args)) == -1) {
            throw new RuntimeException("Второе исключение");
        }
        return 2;
    }

    private static int method3(Object args) {
        if (!(args instanceof Float)) {
            throw new RuntimeException("Третье исключение");
        }
        return 3;
    }
}

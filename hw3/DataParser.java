package hw3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class DataParser {
    public static String[] parseData(String str) {
        String[] words = str.split(" ");
        String[] outArr = new String[6];
        try {
            if (words.length != 6) {
                System.out.println(Arrays.toString(words));
                throw new RuntimeException("Вы ввели меньше или больше запрошенных данных!");
            }
            int idx = 0;
            for (String word : words) {
                if (isAlpha(word) & word.length() > 2) {
                    outArr[idx] = word;
                    idx++;
                }

                if (isValidDate(word) & word.length() == 10) outArr[3] = word;

                if (isNumber(word)) outArr[4] = word;

                if (word.length() == 1 & isAlpha(word)) outArr[5] = word;
            }
            return outArr;
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
            Ui.runApp();
        }
        return outArr;
    }

    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
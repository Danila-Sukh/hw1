package hw3;

public class FullDataInArray {
    public static boolean fullDataInput(String[] array) {
        for (String word : array) {
            if (word == null) return false;
        }
        return true;
    }
}

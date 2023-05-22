package hw3;

public class OutDataBuilder {
    public static String outDataCreate(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append("<");
            sb.append(word);
            sb.append(">");
        }
        return sb.toString();
    }
}
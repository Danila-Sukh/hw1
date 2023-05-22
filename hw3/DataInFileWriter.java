package hw3;

import java.io.FileWriter;
import java.io.IOException;

public class DataInFileWriter {

    public static void dataWriter(String data, String fileName) {
        try {
            FileWriter file = new FileWriter(fileName + ".txt", true);
            file.write(data + "\n");
            System.out.println(data);
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.println("Не удалось сохранить данные в файл!");
            System.out.println(e);
            Ui.runApp();
        }
    }
}

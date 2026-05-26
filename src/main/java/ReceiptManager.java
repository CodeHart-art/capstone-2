import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    public static String FILE_PATH = "src/main/resources/receiptsFolder";


    public static void writeReceipt(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String localDateTime = LocalDateTime.now().format(formatter);
        String fileName = localDateTime + ".txt";

        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(FILE_PATH + "/" + fileName));

            bWriter.write(order.getOrderInfo());
            bWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

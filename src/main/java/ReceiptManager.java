import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReceiptManager {
   public static String FILE_PATH = "src/main/resources/receiptsFolder";


public static void writeReceipt(){
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();



    try {
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(FILE_PATH));




    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


}

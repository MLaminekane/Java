import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
  public static void main(String[] args) {
    String data = "Hello World";
    try {
        FileWriter writer = new FileWriter("filename.txt", true);
        writer.write(data);
        writer.close();
        System.out.println("Complet.");
    } catch (IOException e) {
        System.out.println("Erreur.");
        e.printStackTrace();
    }
  }
}
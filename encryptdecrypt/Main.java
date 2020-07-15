package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        String inPathFile = "";
        String outPathFile = "";
        String alg = "shift";
        int key = 0;

        for (int i = 0; i < args.length - 1; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            } else if ("-in".equals(args[i])) {
                inPathFile = args[i + 1];
            } else if ("-out".equals(args[i])) {
                outPathFile = args[i + 1];
            } else if ("-alg".equals(args[i])) {
                alg = args[i + 1];
            }
        }

        EncoderDecoder coder = new EncoderDecoder();
        coder.setMethod(alg);

        if (!inPathFile.isEmpty() && data.isEmpty()) {
            File inFile = new File(inPathFile);

            try (Scanner scanner = new Scanner(inFile)) {
                while (scanner.hasNext()) {
                    data = data + scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        if (outPathFile.isEmpty()) {
            System.out.print(coder.modeCryption(data, key, mode));
        } else {
            try (FileWriter writer = new FileWriter(outPathFile)) {
                writer.write(coder.modeCryption(data, key, mode));
            } catch (IOException e) {
                System.out.print("Error");
            }
        }

    }
}

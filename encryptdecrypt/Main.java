package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String encryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            str.append((char) (ch + key));
        }

        return str.toString();
    }

    static String decryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            str.append((char) (ch - key));
        }

        return str.toString();
    }

    static String encoder(String data, int key, String mode) {
        if ("enc".equals(mode)) {
            return encryption(data, key);
        } else if ("dec".equals(mode)) {
            return decryption(data, key);
        }

        return "1111";
    }

    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        String inPathFile = "";
        String outPathFile = "";
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
            }
        }

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
            System.out.print(encoder(data, key, mode));
        } else {
            try (FileWriter writer = new FileWriter(outPathFile)) {
                writer.write(encoder(data, key, mode));
            } catch (IOException e) {
                System.out.print("Error");
            }
        }

    }
}

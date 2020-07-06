package encryptdecrypt;
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

    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        int key = 0;

        for (int i = 0; i < args.length - 1; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                data = args[i + 1];
            }
        }
        
        if ("enc".equals(mode)) {
            System.out.println(encryption(data, key));
        } else if ("dec".equals(mode)) {
            System.out.println(decryption(data, key));
        }
    }
}

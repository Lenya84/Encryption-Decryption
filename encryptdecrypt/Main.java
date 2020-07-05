package encryptdecrypt;
import java.util.Scanner;

public class Main {

    static String encryption(char[] text, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : text) {
            str.append((char) (ch + key));
        }

        return str.toString();
    }

    static String decryption(char[] text, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : text) {
            str.append((char) (ch - key));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mode = scanner.nextLine();
        char[] text = scanner.nextLine().toCharArray();
        int key = scanner.nextInt();
        
        if ("enc".equals(mode)) {
            System.out.println(encryption(text, key));
        } else if ("dec".equals(mode)) {
            System.out.println(decryption(text, key));
        }
    }
}

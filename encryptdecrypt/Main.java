package encryptdecrypt;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.nextLine().toCharArray();
        int key = scanner.nextInt();
        
        for (char ch : arr) {
            if (ch >= 97 && ch <= 122) {
                int letter = key + ch;
                System.out.print(letter <= 122 ? (char) letter : (char) (letter - 122 + 96));
                continue;
            }
            
            System.out.print(ch);
        }
    }
}

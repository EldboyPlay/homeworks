import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            System.out.print(new String(chars) + " ");
        }
    }
}

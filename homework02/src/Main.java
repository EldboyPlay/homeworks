import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Character, Character> keyboardMap = new HashMap<>();
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < keyboard.length(); i++) {
            char left = i == 0 ? keyboard.charAt(keyboard.length() - 1) : keyboard.charAt(i - 1);
            keyboardMap.put(keyboard.charAt(i), left);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        char input = scanner.next().charAt(0);

        System.out.println("Буква слева: " + keyboardMap.get(input));
    }
}

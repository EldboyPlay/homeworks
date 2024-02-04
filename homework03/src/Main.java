import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность символов: ");
        String sequence = scanner.nextLine();

        int arrowsCount = 0;
        for (int i = 0; i < sequence.length() - 4; i++) {
            if (sequence.substring(i, i + 5).equals(">>-->") || sequence.substring(i, i + 5).equals("<--<<")) {
                arrowsCount++;
            }
        }

        System.out.println("Количество стрелок: " + arrowsCount);
    }
}

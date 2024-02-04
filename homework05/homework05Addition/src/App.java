import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator; // Убедитесь, что импортировали Comparator

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Television[] tvArray = new Television[10];

        for (int i = 0; i < tvArray.length; i++) {
            System.out.println("Введите информацию для телевизора номер " + (i + 1) + ":");
            System.out.print("Модель: ");
            String model = scanner.next();

            System.out.print("Размер экрана: ");
            int screenSize = scanner.nextInt(); // Допустим, вы забыли этот параметр

            System.out.print("Это умный телевизор? (true/false): ");
            boolean isSmart = scanner.nextBoolean(); // Допустим, вы забыли этот параметр

            System.out.print("Номер канала: ");
            int channelNumber = scanner.nextInt();

            System.out.print("Громкость (0-100): ");
            int volume = scanner.nextInt();

            System.out.print("Телевизор включен? (true/false): ");
            boolean isOn = scanner.nextBoolean();

            // Теперь передаём все 6 параметров в конструктор
            tvArray[i] = new Television(model, screenSize, isSmart, channelNumber, volume, isOn);
        }

        System.out.print("Введите максимально допустимую громкость (рекомендуется от 50 до 70): ");
        int maxVolume = scanner.nextInt();

        Arrays.stream(tvArray)
                .filter(tv -> tv.isOn() && tv.getVolume() <= maxVolume)
                .sorted(Comparator.comparingInt(Television::getChannelNumber))
                .forEach(System.out::println);
    }
}

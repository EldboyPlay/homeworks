public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Примерный массив чисел

        // Проверка на четность
        int[] evenNumbers = Sequence.filter(numbers, n -> n % 2 == 0);

        // Вывод четных чисел
        System.out.println("Четные числа:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Проверка на четность суммы цифр
        int[] evenDigitSumNumbers = Sequence.filter(numbers, n -> {
            int sum = 0, temp = n;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0;
        });

        // Вывод чисел с четной суммой цифр
        System.out.println("Числа с четной суммой цифр:");
        for (int num : evenDigitSumNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
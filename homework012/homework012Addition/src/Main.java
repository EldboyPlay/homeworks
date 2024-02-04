// Main.java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Пример использования метода проверки учетных данных
        if (User.checkCredentials("user", "123", "123")) {
            System.out.println("Учетные данные корректны.");
        } else {
            System.out.println("Учетные данные некорректны.");
        }

        // Чтение данных о пользователе
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество дд.мм.гггг номер телефона пол возраст):");

        try {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length != 7) {
                throw new IllegalArgumentException("Неверное количество аргументов");
            }

            Person person = new Person(parts[0], parts[1], parts[2], parts[3], Long.parseLong(parts[4]), parts[5].charAt(0), Integer.parseInt(parts[6]));
            savePersonToFile(person);
            System.out.println("Данные сохранены успешно.");
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void savePersonToFile(Person person) throws IOException {
        String filename = person.getSurname() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(person.toString());
            writer.newLine();
        }
    }
}

// Класс Person остается неизменным
class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String surname, String name, String patronymic, String birthDate, long phoneNumber, char gender, int age) {
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Неверный формат пола");
        }

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender + " " + age;
    }
}

import model.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryFileImpl;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        // Указываем путь к файлу с данными пользователей
        String filePath = "path/to/your/users.txt";

        // Создаем экземпляр репозитория, передавая путь к файлу
        UsersRepository usersRepository = new UsersRepositoryFileImpl(filePath);

        // Создаем и добавляем пользователей
        User user1 = new User("1", LocalDateTime.now(), "user1", "password1", "password1", "Ivanov", "Ivan", null, 25, true);
        User user2 = new User("2", LocalDateTime.now(), "user2", "password2", "password2", "Petrov", "Petr", null, 30, false);
        User user3 = new User("3", LocalDateTime.now(), "Krylov", "password3", "password3", "Krylov", "Виктор", null, 25, false);
        usersRepository.create(user1);
        usersRepository.create(user2);
        usersRepository.create(user3);

        // Поиск пользователя по ID
        User foundUser = usersRepository.findById("1");
        System.out.println("Найден пользователь: " + foundUser.getLogin());

        // Выгрузка всех пользователей
        System.out.println("Все пользователи:");
        for (User user : usersRepository.findAll()) {
            System.out.println(user.getLogin());
        }

        // Обновление данных пользователя
        user1.setLogin("updatedUser1");
        usersRepository.update(user1);
        System.out.println("Обновленный пользователь: " + usersRepository.findById("1").getLogin());

        // Удаление пользователя по ID
        usersRepository.deleteById("2");
        System.out.println("Пользователь с ID 2 удален");

        // Удаление всех пользователей
        usersRepository.deleteAll();
        System.out.println("Все пользователи удалены");
    }
}

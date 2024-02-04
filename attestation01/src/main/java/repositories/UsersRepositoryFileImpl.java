package repositories;

import model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_PATH = "users.txt"; // Путь к файлу с данными пользователей
    private List<User> users;

    public UsersRepositoryFileImpl(String filePath) {
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    @Override
    public void create(User user) {
        users.add(user);
        saveUsersToFile();
    }

    @Override
    public User findById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User with given ID not found"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void update(User user) {
        int index = findUserIndexById(user.getId());
        if (index != -1) {
            users.set(index, user);
            saveUsersToFile();
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @Override
    public void deleteById(String id) {
        if (users.removeIf(user -> user.getId().equals(id))) {
            saveUsersToFile();
        } else {
            throw new IllegalArgumentException("User with given ID not found");
        }
    }

    @Override
    public void deleteAll() {
        users.clear();
        saveUsersToFile();
    }

    private void loadUsersFromFile() {
        if (!Files.exists(Paths.get(FILE_PATH))) {
            return;
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                User user = parseUser(line);
                if (user != null) {
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (User user : users) {
                String userLine = serializeUser(user);
                writer.write(userLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private User parseUser(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 9) {
            throw new IllegalArgumentException("Invalid line format");
        }
        String id = parts[0];
        LocalDateTime dateAdded = LocalDateTime.parse(parts[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String login = parts[2];
        String password = parts[3];
        String confirmPassword = parts[4];
        String lastName = parts[5];
        String firstName = parts[6];
        String middleName = parts[7].isEmpty() ? null : parts[7];
        Integer age = parts[8].isEmpty() ? null : Integer.parseInt(parts[8]);
        boolean isWorker = Boolean.parseBoolean(parts[9]);

        return new User(id, dateAdded, login, password, confirmPassword, lastName, firstName, middleName, age, isWorker);
    }

    private String serializeUser(User user) {
        return String.join("|",
                user.getId(),
                user.getDateAdded().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                user.getLogin(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getLastName(),
                user.getFirstName(),
                user.getMiddleName() == null ? "" : user.getMiddleName(),
                user.getAge() == null ? "" : String.valueOf(user.getAge()),
                String.valueOf(user.isWorker()));
    }

    private int findUserIndexById(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}

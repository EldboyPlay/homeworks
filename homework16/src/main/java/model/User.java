package model;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class User {
    private String id;
    private LocalDateTime dateAdded;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName; // может быть null
    private Integer age; // может быть null
    private boolean isWorker;

    public User(String id, LocalDateTime dateAdded, String login, String password,
                String confirmPassword, String lastName, String firstName,
                String middleName, Integer age, boolean isWorker) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID format.");
        }
        if (!isValidLogin(login)) {
            throw new IllegalArgumentException("Invalid login format.");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password format.");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }
        if (!isValidName(lastName) || !isValidName(firstName) ||
                (middleName != null && !isValidName(middleName))) {
            throw new IllegalArgumentException("Invalid name format.");
        }

        this.id = id;
        this.dateAdded = dateAdded == null ? LocalDateTime.now() : dateAdded;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID format.");
        }
        this.id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (!isValidLogin(login)) {
            throw new IllegalArgumentException("Invalid login format.");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password format.");
        }
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!isValidName(lastName)) {
            throw new IllegalArgumentException("Invalid name format.");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!isValidName(firstName)) {
            throw new IllegalArgumentException("Invalid name format.");
        }
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName != null && !isValidName(middleName)) {
            throw new IllegalArgumentException("Invalid name format.");
        }
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    // Валидация данных
    private boolean isValidId(String id) {
        return id != null && Pattern.matches("[a-zA-Z0-9-]+", id);
    }

    private boolean isValidLogin(String login) {
        return login != null && Pattern.matches("[a-zA-Z0-9_]+", login) && login.length() < 20 && !login.matches("\\d+");
    }

    private boolean isValidPassword(String password) {
        return password != null && Pattern.matches("[a-zA-Z0-9_]+", password) && password.length() < 20 && !password.matches("[a-zA-Z_]+");
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("[а-яА-Яa-zA-Z]+");
    }


    // другие методы, если необходимо
}


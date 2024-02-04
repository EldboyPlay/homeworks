// User.java
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Геттер для логина
    public String getLogin() {
        return login;
    }

    // Геттер для пароля
    public String getPassword() {
        return password;
    }

    // Статический метод для проверки учетных данных
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("\\w{1,19}")) {
                throw new WrongLoginException("Неверный логин");
            }
            if (!password.matches("\\w{1,19}") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Неверный пароль");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
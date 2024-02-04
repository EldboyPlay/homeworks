public abstract class Person {
    protected String name;
    protected double money;
    protected Product[] cart;
    protected int age;

    public Person(String name, double money, int age, Product[] cart) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (money < 0 || age < 0) {
            throw new IllegalArgumentException("Деньги и возраст не могут быть отрицательными");
        }
        this.name = name;
        this.money = money;
        this.age = age;
        this.cart = cart;
    }

    // Геттеры и сеттеры

    // Абстрактный метод, который будет переопределен в подклассах
    public abstract void purchaseProducts();
}

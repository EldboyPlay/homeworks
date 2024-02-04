import java.io.*;
import java.util.*;
import utils.NumberFormatter;

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Customer {
    String name;
    int money;
    ArrayList<String> productsBought;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
        this.productsBought = new ArrayList<>();
    }

    public boolean buyProduct(Product product) {
        if (this.money >= product.price) {
            this.productsBought.add(product.name);
            this.money -= product.price;
            return true;
        }
        return false;
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        HashMap<String, Customer> customers = new HashMap<>();
        HashMap<String, Product> products = new HashMap<>();
        StringBuilder transactions = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {


            // Чтение данных покупателей
            String line = reader.readLine();
            System.out.println("Считанные данные о покупателях: " + line); // Отладочный вывод
            String[] customerData = line.split("; ");
            for (String data : customerData) {
                data = data.replace(",", "").trim();
                String[] parts = data.split(" = ");
                try {
                    int money = NumberFormatter.parseCount(parts[1]);
                    customers.put(parts[0], new Customer(parts[0], money));
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка в формате денег для покупателя " + parts[0] + ": " + e.getMessage());
                }
            }

            // Чтение данных продуктов
            line = reader.readLine();
            System.out.println("Считанные данные о продуктах: " + line); // Отладочный вывод
            String[] productData = line.split("; ");
            for (String data : productData) {
                data = data.trim().replace(";", "");
                String[] parts = data.split(" = ");
                try {
                    int price = NumberFormatter.parseCount(parts[1].trim());
                    products.put(parts[0], new Product(parts[0], price));
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка в формате цены для продукта " + parts[0] + ": " + e.getMessage());
                }
            }

            // Обработка покупок
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Удаление лишних пробелов в начале и конце строки
                if (line.isEmpty() || line.equals("END")) {
                    break; // Прекращаем чтение, если строка пустая или содержит "END"
                }

                System.out.println("Обрабатывается строка: " + line); // Отладочный вывод
                String[] parts = line.split(" ");

                Customer customer = customers.get(parts[0]);
                Product product = products.get(parts[1]);

                if (customer != null && product != null) {
                    if (customer.buyProduct(product)) {
                        transactions.append(customer.name).append(" купил(а) ").append(product.name).append("\n");
                    } else {
                        transactions.append(customer.name).append(" не может позволить себе ").append(product.name).append("\n");
                    }
                    System.out.println(customer.name + " теперь имеет " + customer.money + " и купил: " + customer.productsBought); // Отладочный вывод
                }
            }

            // Запись транзакций и итогов
            writer.print(transactions.toString());
            for (Customer customer : customers.values()) {
                writer.print(customer.name + " - ");
                if (customer.productsBought.isEmpty()) {
                    writer.println("Ничего не куплено");
                } else {
                    writer.println(String.join(", ", customer.productsBought));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}

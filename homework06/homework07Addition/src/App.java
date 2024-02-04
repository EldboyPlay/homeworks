import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Product> discountProducts = new ArrayList<>();

        try {
            products.add(new Product("Хлеб", 40.0, true));
            products.add(new Product("Молоко", 60.0, true));
            discountProducts.add(new DiscountProduct("Торт", 800.0, true, 15.0, LocalDate.now().plusDays(2)));
            discountProducts.add(new DiscountProduct("Кофе растворимый", 432.0, true, 50.0, LocalDate.now().plusDays(2)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Обычные продукты: ");
        products.forEach(product -> System.out.println(product.toString()));

        System.out.println("Акционные продукты: ");
        discountProducts.forEach(product -> System.out.println(product.toString()));
    }
}

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, double price, boolean isAvailableForChildren, double discount, LocalDate discountEndDate) {
        super(name, price, isAvailableForChildren);
        if (discount <= 0 || discount >= 100) {
            throw new IllegalArgumentException("Недопустимый размер скидки");
        }
        this.discount = discount;
        this.discountEndDate = discountEndDate;
    }

    // Переопределение метода getPrice для учета скидки
    @Override
    public double getPrice() {
        if (LocalDate.now().isBefore(discountEndDate)) {
            return super.getPrice() * (1 - discount / 100);
        }
        return super.getPrice();
    }

    // Геттеры и сеттеры
    public double getDiscount() {
        return discount;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscount(double discount) {
        if (discount <= 0 || discount >= 100) {
            throw new IllegalArgumentException("Недопустимый размер скидки");
        }
        this.discount = discount;
    }

    @Override
    public String toString() {
        String discountInfo = (LocalDate.now().isBefore(discountEndDate)) ?
                (", Скидка: " + discount + "% до " + discountEndDate) :
                (", Скидка закончилась " + discountEndDate);
        return "Скидочный " + super.toString() + discountInfo;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        this.discountEndDate = discountEndDate;
    }
}
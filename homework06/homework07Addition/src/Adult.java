public class Adult extends Person {
    private boolean canPurchaseOnCredit;

    public Adult(String name, double money, int age, Product[] cart, boolean canPurchaseOnCredit) {
        super(name, money, age, cart);
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Недопустимый возраст для взрослого");
        }
        this.canPurchaseOnCredit = canPurchaseOnCredit;
    }

    @Override
    public void purchaseProducts() {
        // Логика покупки товаров для взрослых...
    }

    public boolean canPurchaseOnCredit() {
        return canPurchaseOnCredit;
    }
}

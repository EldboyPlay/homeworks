public class Television {
    private String model;
    private int screenSize;
    private boolean isSmart;

    // Конструктор
    public Television(String model, int screenSize, boolean isSmart) {
        this.model = model;
        this.screenSize = screenSize;
        this.isSmart = isSmart;
    }

    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Телевизор{" +
                "модель='" + model + '\'' +
                ", размер экрана=" + screenSize +
                ", умный=" + isSmart +
                '}';
    }
}

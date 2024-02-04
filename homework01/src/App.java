public class App {
    public static void main(String[] args) {
        // Создаем объекты класса Телевизор
        Television tv1 = new Television("Samsung", 55, true);
        Television tv2 = new Television("LG", 42, false);

        // Вывод информации о телевизорах
        System.out.println(tv1);
        System.out.println(tv2);

        // Изменение данных второго телевизора с использованием сеттеров
        tv2.setModel("LG Updated Model");
        tv2.setScreenSize(45);

        // Повторный вывод информации о втором телевизоре после изменений
        System.out.println(tv2);
    }
}

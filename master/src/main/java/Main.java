public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(10, "Синий", "Зеленый");
        Figure triangle = new Triangle(3, 4, 5, "Фиолетовый", "Зелубой");
        Figure rectangle = new Rectangle(2, 4, "Белый", "Черный");

        printFigureInfo(circle);
        printFigureInfo(triangle);
        printFigureInfo(rectangle);
    }

    public static void printFigureInfo(Figure figure) {
        System.out.println("Площадь = " + figure.calculateArea());
        System.out.println("Периметр = " + figure.calculatePerimeter());
        System.out.println("Цвет заливки " + figure.getFillColor());
        System.out.println("Цвет граней " + figure.getBorderColor());
    }
}

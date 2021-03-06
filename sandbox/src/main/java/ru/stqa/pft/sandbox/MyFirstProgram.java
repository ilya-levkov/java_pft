package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        /*
        hello("world");
        hello("user");
        hello("Ilya");
        */

        Point p1 = new Point(2, 4);
        Point p2 = new Point(5, 6);

        // функция
        System.out.println("Расстояние между точками p1(" + p1.x + " ," + p1.y + ") " +
            "и p2(" + p2.x + " ," + p2.y + ") равно " + distance(p1, p2));
        // метод
        System.out.println("Расстояние между точками:" + p1.distance(p2));

        /*
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());
        */

    }
    /*
    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
    */

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }

}
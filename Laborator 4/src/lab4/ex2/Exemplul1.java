package lab4.ex2;

public class Exemplul1 {
    public static void main(String[] args){
        Circle c1 = new Circle();
        Line l1 = new Line();
        Triangle t1 = new Triangle();

        Shape shape;

        shape = c1;
        shape.draw();
        shape.remove();

        shape = l1;
        shape.draw();
        shape.remove();

        shape = t1;
        shape.draw();
        shape.remove();

        shape = l1;
        if (shape instanceof Line){
            System.out.println("Shape is of type Line");
        }
    }
}

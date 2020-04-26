package lab4.ex2;

public class Triangle extends Shape {

    public Triangle() {
    }

    @Override
    public void draw() {
        System.out.println("Draw a triangle");
    }

    @Override
    public void remove() {
        System.out.println("Remove a triangle");
    }
}

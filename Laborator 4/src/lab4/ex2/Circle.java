package lab4.ex2;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Draw a circle");
    }

    @Override
    public void remove() {
        System.out.println("Remove a circle");
    }
}

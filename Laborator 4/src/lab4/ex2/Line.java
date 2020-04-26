package lab4.ex2;

public class Line extends Shape{
    @Override
    public void draw() {
        System.out.println("Draw a line");
    }

    public Line() {
        super();
    }

    @Override
    public void remove() {
        System.out.println("Remove a line");
    }
}

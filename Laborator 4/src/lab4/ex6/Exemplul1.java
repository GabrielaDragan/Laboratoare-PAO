package lab4.ex6;

public class Exemplul1 {

    public static void main(String[] args) {
        Age age = new Age(1993, 9, 26);

        ImmutableStudent student = new ImmutableStudent("Silvia", age);
        System.out.println(student.getName() + " " + student.getAge());

        age.setDay(28);
        System.out.println(student.getName() + " " + student.getAge());
    }
}

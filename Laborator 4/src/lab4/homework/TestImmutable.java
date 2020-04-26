package lab4.homework;

public class TestImmutable {
    public static void main(String[] args) {

        Age age = new Age(24, 9, 1998);
        ImmutableStudent s = new ImmutableStudent(1, "Ana", age);

        System.out.println("Age: " + age.getDay() + age.getMonth() + age.getYear());
        System.out.println("Immutable student: " + s.getName() + s.getAge().getYear());
    }
}

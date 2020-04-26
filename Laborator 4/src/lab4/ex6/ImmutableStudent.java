package lab4.ex6;

public final class ImmutableStudent {

    private final String name;
    private final Age age;

    public ImmutableStudent(String name, Age age) {
        this.name = name;
        Age clonedAge = new Age(age.getYear(), age.getMonth(), age.getDay());
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Age getAge() {
        return this.age;
    }
}

package lab3;

public class Student extends Person {

    private int noOfClasses;

    public Student(int age, String name, int noOfClasses){
        super(age, name);
        this.noOfClasses = noOfClasses;
    }

    public int getNoOfClasses() {
        return noOfClasses;
    }

    public void setNoOfClasses(int noOfClasses) {
        this.noOfClasses = noOfClasses;
    }
}

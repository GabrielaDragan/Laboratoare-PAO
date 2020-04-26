package lab4.homework;

public class Departament {

    private String name;
    private Student[] students;

    public Departament(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students){
        this.students = students;
    }
}

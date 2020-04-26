package lab4.homework;

public class TestDepartament {
    public static void main(String[] args) {
        Student s1 = new Student("Silvia", "Butan", 7);
        Student s2 = new Student("Maria", "Popescu", 8);

        Student[] students = {s1, s2};

        Departament departament = new Departament("IT", students);

        System.out.println(departament.getName());
        System.out.println(departament.getStudents().length);
    }
}

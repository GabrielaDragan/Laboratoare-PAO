package Pachet4;

import Pachet2.Person;
import Pachet3.Room;

public class Exercitiul4 {
    public static void main(String[] args){
        Subject s1 = new Subject();
        Subject s2 = new Subject();

        Room r1 = new Room();
        r1.setNumber("12A");
        r1.setType("normal");
        r1.setFloor(3);

        Room r2 = new Room();
        r2.setNumber("12B");
        r2.setType("tech");
        r2.setFloor(7);

        Person p1 = new Person();
        p1.setName("John");
        p1.setSurname("Doe");
        p1.setAge(24);
        p1.setIdNo("1123444");
        p1.setType("student");

        Person p2 = new Person();
        p2.setName("John");
        p2.setSurname("Roe");
        p2.setAge(56);
        p2.setIdNo("2233444");
        p2.setType("teacher");

        s1.setRoom(r1);
        s1.setNoOfStudents(3);
        s1.setTeacher(p1);

        s2.setRoom(r2);
        s2.setNoOfStudents(3);
        s2.setTeacher(p2);

        System.out.println(s1.getRoom().getNumber());
    }
}

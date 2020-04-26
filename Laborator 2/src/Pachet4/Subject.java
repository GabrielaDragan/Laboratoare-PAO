package Pachet4;

import Pachet2.Person;
import Pachet3.Room;

public class Subject {
    private Pachet3.Room room;
    private int noOfStudents;
    private Pachet2.Person teacher;

    public Subject() {

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
}

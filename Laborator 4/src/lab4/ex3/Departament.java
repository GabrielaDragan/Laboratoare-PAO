package lab4.ex3;

public class Departament {

    private String name;
    private Profesor[] professors;

    public Departament(String name, Profesor[] professors) {
        this.name = name;
        this.professors = professors;
    }

    public String getName() {
        return name;
    }

    public Profesor[] getProfessors() {
        return professors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(Profesor[] professors) {
        this.professors = professors;
    }
}

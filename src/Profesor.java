public class Profesor implements Human {
    String nume, prenume, acronimFacultate, materie;
    Integer varsta;

    public Profesor(String nume, String prenume, String acronimFacultate, String materie, Integer varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.materie = materie;
        this.varsta = varsta;
    }

    @Override
    public void greeting() {

    }

    @Override
    public void doWork() {

    }

    @Override
    public Integer getAge()
    {
        return this.varsta;
    }

    @Override
    public String toString() {
        return "[Prof. " + nume + " " + prenume + ", Fac. " + acronimFacultate + ", Varsta: " +
                varsta.toString() + ", Materie predata - " + materie + "]";
    }

    @Override
    public int compareTo(Human secondHuman) {
        return Integer.compare(this.getAge(),secondHuman.getAge());
    }
}

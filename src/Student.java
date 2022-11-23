public class Student implements Human {
    String nume, prenume, acronimFacultate;
    Integer varsta, anStudiu;

    public Student(String nume, String prenume, String acronimFacultate, Integer varsta, Integer anStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
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
        return "[Sd. " + nume + " " + prenume + ", Anul " + anStudiu.toString() + ", Fac. " +
                acronimFacultate + ", Varsta: " + varsta.toString() + "]";
    }

    @Override
    public int compareTo(Human secondHuman) {
        return Integer.compare(this.getAge(),secondHuman.getAge());
    }
}

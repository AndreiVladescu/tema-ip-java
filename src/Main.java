public class Main {
    public static void main(String[] args) {
        Student andrei = new Student("Vladescu", "Andrei", "Calc.", 22, 4);
        Profesor mihai = new Profesor("Togan", "Mihai", "Calc.", "Ingineria Programarii", 50);

        System.out.println(andrei);
        System.out.println(mihai);
    }
}
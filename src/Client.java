import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try {
            Socket me = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String fromServer, fromUser;

            String[] mesaje = {"Student Kennedy John ATM 2 19",
                    "Student ABC DEF EFG 5 100",
                    "Profesor TEST PROFESOR FACULTATE KARATE 99"};

            System.out.println("Sending messages...");

            out = new PrintWriter(me.getOutputStream(), true);

            for (int i = 0; i < mesaje.length; i++)
                out.println(mesaje[i]);
            out.println("Show");
            out.println("Exit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
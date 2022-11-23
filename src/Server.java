import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;

public class Server {
    static ArrayList<Human> humanList = new ArrayList<Human>();

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(client);
                clientSock.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ClientHandler class
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        // Constructor
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void showHumans()
        {
            Collections.sort(humanList);
            for (Human h : humanList) {
                System.out.println(h.toString());
            }
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                while (true) {
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        if (line.equals("Exit"))
                            break;

                        if (line.equals("Show"))
                            showHumans();

                        String[] split = line.split(" ");

                        if (split[0].equals("Student")) {
                            humanList.add(new Student(split[1], split[2], split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5])));
                        }
                        if (split[0].equals("Profesor")) {
                            humanList.add(new Profesor(split[1], split[2], split[3], split[4], Integer.parseInt(split[5])));
                        }
                    }
                }
            }
            catch (SocketException e) {
                System.out.println("Connection lost with client " + this.clientSocket.getInetAddress().getHostAddress());
            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
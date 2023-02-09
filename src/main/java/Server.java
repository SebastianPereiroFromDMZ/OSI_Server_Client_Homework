import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("server started");
        int port = 8084;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort());

                while (!clientSocket.isClosed()) {

                    final String clientConnect = in.readLine();


                    out.println("Write your name");

                    String clientName = in.readLine();

                    out.printf("Hi %s. Are you child? (yes/no) %n", clientName);

                    String yesOrNo = in.readLine();
                    System.out.println(yesOrNo);

                    if (yesOrNo.equalsIgnoreCase("yes")){
                        out.println("Welcome to the kids area " + clientName + "Let's play!");
                        System.out.println("server closed");
                        break;
                    } else if (yesOrNo.equalsIgnoreCase("no")) {
                        out.println("Welcome to the adult zone " + clientName +
                                "have a good rest, or a good working day!");
                        System.out.println("server closed");
                        break;
                    }else {
                        out.println("wrong input, repeat the cycle again");
                    }
                }
            }
        }
    }
}


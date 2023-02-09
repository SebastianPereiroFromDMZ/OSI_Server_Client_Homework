import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {


    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8084;

        try (Socket clientSocket = new Socket(host, port);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("enter any character to connect to the server");

            while (!clientSocket.isClosed()) {

                String clientCommand = br.readLine();
                out.println(clientCommand);

                String resp = in.readLine();
                System.out.println(resp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
Можно вопрос?) Подскажите пожалуйста, как закрыть Клиента, после закрытия Сервера без Краша?
 Спасибо
 */

package lesson06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        ServerSocket server = null;
        Socket client = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            client = server.accept();
            System.out.println("Клиент подключился!");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            while (!client.isClosed()) {

                /*System.out.println("Сервер считывает канал");*/
                String message = in.readUTF();
                System.out.println("Прочитано из сообщения клиента - " + message);
                if (br.ready()) {
                    // System.out.println("Клиент начал запись");
                    message = br.readLine();
                    out.writeUTF(message);
                    System.out.println("Сервер ответил: " + message);
                }
                /*System.out.println("Сервер пытается записать в канал");*/

                if (message.equals("/end")) {
                    System.out.println("Клиент хочет завершить сессию");
                    out.writeUTF("Ответ сервера" + message + " - ОК");
                    out.flush();
                    break;
                }
                out.writeUTF("Ответ сервера" + message + "- ОК");
                System.out.println("Сервер отправил сообщение клиенту");
                out.flush();
            }

            System.out.println("Клиент завершил сессию");
            System.out.println("Закрываем соединение");
            in.close();
            out.close();
            client.close();
            System.out.println("Закрытие соединений завершено");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

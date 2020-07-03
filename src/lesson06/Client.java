package lesson06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws InterruptedException{
        final int PORT = 8189;
        String IP_ADDRESS = "localhost";

        Socket client;
        /*Scanner in;
        PrintWriter out;*/


        try {
            client = new Socket(IP_ADDRESS, PORT);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(client.getOutputStream());
            DataInputStream ois = new DataInputStream(client.getInputStream());

            System.out.println("Вы подключены");
            System.out.println();

            while (!client.isOutputShutdown()) {
                if (br.ready()) {
                    // System.out.println("Клиент начал запись");
                    String message = br.readLine();

                    oos.writeUTF(message);
                    oos.flush();
                    System.out.println("Вы написали " + message);
                    if (message.equals("/end")) {
                        System.out.println("Вы закрыли соединение");
                        //if (ois.read() > -1) {
                        //    String in = ois.readUTF();
                        //    System.out.println(in);
                        // }
                        break;
                  //  }
                    //if (ois.read() > -1) {
                      //  String in = ois.readUTF();
                        //System.out.println(in);
                    }
                }
            }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



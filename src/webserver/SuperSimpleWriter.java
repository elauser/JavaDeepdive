package webserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SuperSimpleWriter {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5000);
            System.out.println("Connection established");
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String outputString;
            do{
                System.out.println("Write a message to the server");
                outputString = scanner.nextLine();
                pw.println(outputString);
            }while(!outputString.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

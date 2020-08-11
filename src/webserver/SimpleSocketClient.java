package webserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleSocketClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)){
            BufferedReader echo = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do{
                System.out.println("Enter String to be echoed");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);

                if(!echoString.equals("exit")){
                    response = echo.readLine();
                    System.out.println(response);
                }
            }while(!echoString.equals("exit"));
        }catch(IOException e){
            System.out.println("Exception on Socket: " + e.getMessage());
        }

    }
}

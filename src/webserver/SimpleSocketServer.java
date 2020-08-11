package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while(true){
                String inputString = input.readLine();
                if(inputString.toLowerCase().equals("exit")){
                    System.out.println("Exiting Server");
                    break;
                }
                output.println("Echo from server" + inputString);
            }
        } catch (IOException e){

            System.out.println("IOException: " + e.getMessage());
        }

    }
}

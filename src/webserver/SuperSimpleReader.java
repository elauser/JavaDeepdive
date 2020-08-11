package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SuperSimpleReader {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(5000)){
            Socket socket = ss.accept();
            System.out.println("Connection established");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputString;
            do{
                inputString = br.readLine();
                System.out.println(inputString);
            } while(!inputString.equals("exit"));

        }catch(IOException e){
            System.out.println("IOException trying to open ServerSocket");
            e.printStackTrace();
        }
    }
}

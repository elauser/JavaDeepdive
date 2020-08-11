package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Echos extends Thread {
    Socket socket;

    public Echos(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        String inputString = "";
        do{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                inputString = br.readLine();
                System.out.println("Received: " + inputString);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while(!inputString.equals("exit"));
    }
}

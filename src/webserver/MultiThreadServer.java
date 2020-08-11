package webserver;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiThreadServer {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(5000)){
            while(true){
                new Echos(ss.accept()).start();
            }
        }catch(IOException e){
            System.out.println("whoopsie daisie");
            e.printStackTrace();
        }

    }
}

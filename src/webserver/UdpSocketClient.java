package webserver;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpSocketClient {
    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do{
                System.out.println("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);
            } while (!echoString.equals("exit"));


        } catch(SocketTimeoutException f){
            f.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

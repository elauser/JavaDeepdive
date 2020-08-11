package webserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpSocketServer {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(5000);

            while(true){
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("Start Waiting for Packets");
                socket.receive(packet);
                System.out.println("Text received is " + new String(buffer));
            }
        } catch(SocketException e){
            System.out.println("SocketException: " + e.getMessage());
        } catch(IOException f){
            System.out.println("IOException " + f.getMessage());
        }
    }
}

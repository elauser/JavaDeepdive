package webserver;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWebserver {
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 1);
            HttpContext context = httpServer.createContext("/");
            context.setHandler(exchange -> {
                String s = "<h1>Hello World</h1>";
                exchange.sendResponseHeaders(200, s.length());
                OutputStream os = exchange.getResponseBody();
                os.write(s.getBytes());
                os.close();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

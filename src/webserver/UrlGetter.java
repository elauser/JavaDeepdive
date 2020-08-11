package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlGetter {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String output = "";
            while(output!=null){
                output = br.readLine();
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGet {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            int responseCode = urlConnection.getResponseCode();
            System.out.println("response code = " + responseCode);

            if(responseCode != 200){
                System.out.println("Unsuccesfull Connection");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while(line != null){
                line = br.readLine();
                System.out.println(line);
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

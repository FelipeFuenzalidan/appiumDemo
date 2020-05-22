package utils;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestUtil.class);

    public void post(JsonObject json, String urlString) {
        URL url = null;
        try {
            LOGGER.info("Enviando datos a " + urlString);
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            StringBuilder sb = new StringBuilder();
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                LOGGER.info("El envío fue exitoso");
                LOGGER.info(con.getResponseMessage());
            } else {
                LOGGER.info("El envío fallo con el siguiente resultado: " + con.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

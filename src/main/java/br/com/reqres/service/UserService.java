package br.com.reqres.service;

import br.com.reqres.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static UserResponse createUser(String path, UserResponse userResponse) throws Exception {
        Map<String, String> body = new HashMap<>();
        URL url = new URL(path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoInput(true);
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");


        body.put("name", userResponse.getName());
        body.put("job", userResponse.getJob());

        // Valida se tem dados no corpo da requisição
        if(body != null){
            try{
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String data = ow.writeValueAsString(body);

                byte[] out = data.getBytes(StandardCharsets.UTF_8);

                OutputStream stream = http.getOutputStream();
                stream.write(out);
            }
            catch(RuntimeException e){
                throw new Exception("Erro"+e.getMessage());
            }

        }

        InputStream inputStream = http.getInputStream();

        UserResponse response = new ObjectMapper().readValue(inputStream, UserResponse.class);

        return response;
    }
}

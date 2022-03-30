package br.com.reqres;

import br.com.reqres.model.UserResponse;
import br.com.reqres.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        String path = "https://reqres.in/api/users";

        // Requisição POST
        UserResponse user = UserService.createUser(path, new UserResponse("Bruno", "Java Developer"));

        System.out.println(user.toString());
    }
}

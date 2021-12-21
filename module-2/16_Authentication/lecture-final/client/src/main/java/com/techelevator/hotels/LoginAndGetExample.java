package com.techelevator.hotels;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class LoginAndGetExample {

    public static void main(String[] args) {

        // 1) Login with a POST request and retrieve the jwt
        // 2) store the jwt
        // 3) make a get request to passing the JWT in the header and using exchange
        // 4) retrieve the derserialized response object from the ResponseEntity<> using getBody()

        RestTemplate restTemplate = new RestTemplate();

        String username = "user";
        String password = "password";
        String baseUrl = "http://localhost:8080/";
        String token = "";

        // LOGIN
        // Step 1: Build the Login object
        LoginDTO login = new LoginDTO("user,password");
        login.setUsername(username);
        login.setPassword(password);

        // Step 2: Build the Header for a POST
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginDTO> loginEntity = new HttpEntity<>(login, headers);

        // Step 3: Do the POST request using exchange      ( url,  HttpMethod, HttpEntity, Class to deserialize to)
        ResponseEntity<Map> loginResponse = restTemplate.exchange(baseUrl + "login", HttpMethod.POST, loginEntity, Map.class);

        // Step 4: Get the Token from the response and store it
        token = (String) loginResponse.getBody().get("token");


        // USING THE TOKEN FOR A GET REQUEST

        // Step 1: Build the Header with the token
        HttpHeaders getHeader = new HttpHeaders();
        getHeader.setBearerAuth(token);
        HttpEntity entity = new HttpEntity<>(getHeader);

        // Step 2: Use Exchange to make the GET request
        ResponseEntity<Hotel> getResponse = restTemplate.exchange(baseUrl + "hotels/1", HttpMethod.GET, entity, Hotel.class);

        // Step 3: Call getBody() on the ResponseEntity to retrieve the deserialized response object
        Hotel hotel = getResponse.getBody();

        System.out.println(hotel);
    }
}

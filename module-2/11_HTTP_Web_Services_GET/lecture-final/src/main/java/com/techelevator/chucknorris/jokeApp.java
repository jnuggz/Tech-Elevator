package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class jokeApp {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        String url = "http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy";

        JokeReturn jokeReturn = restTemplate.getForObject(url, JokeReturn.class);

        System.out.println(jokeReturn.getValue().getJoke());

    }
}

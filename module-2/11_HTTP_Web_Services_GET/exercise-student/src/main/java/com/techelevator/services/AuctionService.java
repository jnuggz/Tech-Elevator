package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
        Auction[] auctions = restTemplate.getForObject(BASE_URL, Auction[].class);
        return auctions;
    }

    public Auction listDetailsForAuction(int id) {
        String url = BASE_URL + "/" + id;
        Auction auction = restTemplate.getForObject(url, Auction.class);
        return auction;
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        String url = BASE_URL + "?title_like=" + title;
        Auction[] auctionTitle = restTemplate.getForObject(url, Auction[].class);
        return auctionTitle;
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        String url = BASE_URL + "?currentBid_lte=" + price;
        Auction[] auctionPrice = restTemplate.getForObject(url, Auction[].class);
        return auctionPrice;
    }

}

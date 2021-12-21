package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLOptionElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public List<Auction> list(@RequestParam(name = "title_like", required = false, defaultValue = "") String searchWord,
                              @RequestParam(name = "currentBid_lte", required = false, defaultValue = "0") Double maxBid) {

        List<Auction> auctions = dao.list();

        if(!(searchWord.equals("")) && maxBid != 0) {
            return dao.searchByTitleAndPrice(searchWord, maxBid);
        }
        if(maxBid != 0) {
            return dao.searchByPrice(maxBid);
        }
        if(!(searchWord.equals(""))) {
            return dao.searchByTitle(searchWord);
        }
        return auctions;
    }

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(path="", method=RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }



}

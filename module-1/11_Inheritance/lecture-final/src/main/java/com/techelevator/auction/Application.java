package com.techelevator.auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        //long way (what we are used to)
        Bid joshBid = new Bid("Josh", 1);
        generalAuction.placeBid(joshBid);
        //shorthand to create a new object
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Jenny", 13));

        generalAuction.yellsAtUsers();

        System.out.println("This is our auction:");
        for(Bid currentBid : generalAuction.getAllBids()){
            System.out.println(currentBid.getBidder() + ": " + currentBid.getBidAmount());
        }

        System.out.println("Winning bid for general auction:");
        generalAuction.getHighBid().getBidder();
        System.out.println(generalAuction.getHighBid() + ": " + generalAuction.getHighBid().getBidAmount());

        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Reserve Auction");
        System.out.println();
        System.out.println();

        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Hat", 65);

        reserveAuction.placeBid(new Bid("Ted Mosby", 35));
        reserveAuction.placeBid(new Bid("Marshal Erickson", 55));
        reserveAuction.placeBid(new Bid("Barney Stinson", 80));
        reserveAuction.placeBid(new Bid("Lily Erickson", 60));
        reserveAuction.placeBid(new Bid("Robin Sherbatsky", 85));

        reserveAuction.yellsAtUsers();

        for(Bid currentReserveBid : reserveAuction.getAllBids()){
            System.out.println(currentReserveBid.getBidder() + ": " + currentReserveBid.getBidAmount());
        }
        System.out.println("Reserve auction winner is:");
        System.out.println(reserveAuction.getHighBid().getBidder() + ": " + reserveAuction.getHighBid().getBidAmount());

        System.out.println();
        System.out.println("--------------");
        System.out.println("Buyout Auction");
        System.out.println();
        System.out.println();

        BuyoutAuction buyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug",55);

        buyoutAuction.yellsAtUsers();


        buyoutAuction.placeBid(new Bid("Rick Astley", 20));
        buyoutAuction.placeBid(new Bid("Michael Scott", 30));
        buyoutAuction.placeBid(new Bid("Dwight Schrute", 25));
        buyoutAuction.placeBid(new Bid("Ryan Howard", 56));

        for(Bid currentBuyoutAuction : buyoutAuction.getAllBids()){
            System.out.println(currentBuyoutAuction.getBidder() + ": " + currentBuyoutAuction.getBidAmount());
        }

        System.out.println("Buyout Auction Winner");
        System.out.println(buyoutAuction.getHighBid().getBidder() + ": " + buyoutAuction.getHighBid().getBidAmount());

        //example to show that calling buyoutAuction.placeBid() returns true/false
        System.out.println(buyoutAuction.placeBid(new Bid("Kelly K", 20)));

        // Add the General Auction, Reserve Auction, and Buyout Auction to a list of data type Auction
        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(reserveAuction);
        auctions.add(buyoutAuction);

        showWinners(auctions);

        Auction regAuction = new Auction("Head First Java");
        Auction resAuction = new ReserveAuction("TE Calendar", 20 );
        Auction buyAuction = new BuyoutAuction("TE Pen", 20);

        List<Auction> listOfAuctions = new ArrayList<Auction>();
        listOfAuctions.add( regAuction );
        listOfAuctions.add( resAuction );
        listOfAuctions.add( buyAuction );

        Bid johnsBid = new Bid("John Fulton", 25);
        Bid stevesBid = new Bid("Steve", 15);
        Bid rachelleBid = new Bid("Rachelle", 30);
        

        for (Auction auction: listOfAuctions) {
            auction.placeBid(johnsBid);
            auction.placeBid(stevesBid);
            auction.placeBid(rachelleBid);
        }

        showWinners(listOfAuctions);

    }

    private static void showWinners(List<Auction> auctions) {
        for (Auction auction : auctions) {
            System.out.println(auction.getItemForSale() + " sold to "
                    + auction.getHighBid().getBidder() + " for $"
                    + auction.getHighBid().getBidAmount());
        }
    }


}

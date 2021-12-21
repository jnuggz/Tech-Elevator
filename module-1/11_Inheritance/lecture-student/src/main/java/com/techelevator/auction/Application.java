package com.techelevator.auction;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        //All bids below are added to the List of Bids in Auction.java
        //Debugging and stepping into the bids below will go to the Method in Auction.java
        Bid joshBid = new Bid("Josh", 1);
        //above line is same as below, the long way
        generalAuction.placeBid(joshBid);
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Jenny", 13));


        System.out.println("This is our auction:");
        for(Bid currentBid : generalAuction.getAllBids()) {
            System.out.println(currentBid.getBidder() + ": " + currentBid.getBidAmount());
        }

        //Called method from auction.java and bid.java
        System.out.println("Highest Bidder for general auction:");
        System.out.println(generalAuction.getHighBid().getBidder() + ": "
                + generalAuction.getHighBid().getBidAmount());

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
    }






        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
}

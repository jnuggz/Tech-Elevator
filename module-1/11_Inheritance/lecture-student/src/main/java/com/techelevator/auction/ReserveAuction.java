package com.techelevator.auction;

public class ReserveAuction extends Auction {

    private int reservePrice;

    //super will invoke the superclass Constructor
    public ReserveAuction (String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    //Subclass will inherit some properties from the parent class
    //Subclass also have unique properties that differ from parent class
    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        //need to find out is offeredBid high enough?
        if(offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }
}



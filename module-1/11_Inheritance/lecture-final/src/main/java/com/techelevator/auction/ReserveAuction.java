package com.techelevator.auction;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice){
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        //is the offeredBid high enough?
        if(offeredBid.getBidAmount() >= reservePrice){
            //since it is, let find out if it is the highest bid
            //cool lets use the work from super!
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

}

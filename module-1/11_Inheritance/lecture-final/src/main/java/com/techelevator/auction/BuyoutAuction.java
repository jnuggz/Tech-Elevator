package com.techelevator.auction;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    /*
     * This class overrides the default placeBid behavior of the parent class.
     * If the offeredBid meets or exceeds the buyout price, the bid is set
     * to the buyout price and all future bids are ignored.
     */

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        //if the buyout price is not met
        if(getHighBid().getBidAmount() < buyoutPrice){
            //if the bid amount is greater than or equal to buyout - do something special!
            if(offeredBid.getBidAmount() >= buyoutPrice){
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            //otherwise do what's normal
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }
}

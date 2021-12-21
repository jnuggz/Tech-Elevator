package com.techelevator.auction;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    /*
        This class overrides the default placeBid behavior of th parent class.
        If the offerBid meets or exceeds the buyout price, the bid is set
        to the buyout price and all future bids are ignored.
     */

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        //if the buyout price is not met
        if (getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;

    }
}


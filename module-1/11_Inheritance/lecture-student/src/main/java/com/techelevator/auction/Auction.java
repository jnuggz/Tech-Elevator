package com.techelevator.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	//Member Variable
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;

	//Constructor
	//new Bid is calling on the constructor from Bid.java
	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}
	//Method
	//The Bid Object will know the bidder name and bid amount
	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}

	public String yellsAtUsers(){
		return "I am a Reserve Auction method";
	}
}

package com.cs.srs.model.data;

import java.util.HashMap;

public class Item extends SRSData {
    private String name;
    private String price;
    private String description;

    public enum State {
	BEFORE_PAYMENT, ACCEPT, SHIP, ARRIVAL, REFUND;
	public String toString() {
	    switch(this) {
	    case BEFORE_PAYMENT:
		return "before_payment";
	    case ACCEPT:
		return "accept";
	    case SHIP:
		return "ship";
	    case ARRIVAL:
		return "arrival";
	    case REFUND:
		return "refund";
	    }
            return null;
	}
	
	public static State toState(String input) {
	    if (input.equals("accept"))
		return ACCEPT;
	    if (input.equals("ship"))
		return SHIP;
	    if (input.equals("arrival"))
		return ARRIVAL;
	    if (input.equals("refund"))
		return REFUND;
	    return BEFORE_PAYMENT;
	}
    };
    
    public Item(int id, String name, int price, String description) {
	super(id);
	setName(name);
	setPrice(price);
	setDescription(description);
    }

    public Item(String name, int price, String description) {
	this(0, name, price, description);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), name, price, description };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("name", name);
	pair.put("price", price);
	pair.put("description", description);
	return pair;
    }

    public void setName(String name) {
	this.name = getDQuoteString(name);
    }

    public void setPrice(int price) {
	this.price = "" + price;
    }

    public void setDescription(String description) {
	this.description = getDQuoteString(description);
    }

    public String getName() {
	return getDQuoteFreeString(name);
    }

    public int getPrice() {
	return Integer.parseInt(price);
    }

    public String getDescription() {
	return getDQuoteFreeString(description);
    }
}
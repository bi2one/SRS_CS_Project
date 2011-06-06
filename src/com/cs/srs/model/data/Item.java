package com.cs.srs.model.data;

import java.util.HashMap;

public class Item extends SRSData {
    private String name;
    private String price;
    private String description;

    public enum State {
	BEFORE_PAYMENT, AFTER_DELIVERY;
	public String toString() {
	    switch(this) {
	    case BEFORE_PAYMENT:
		return "before_payment";
	    case AFTER_DELIVERY:
		return "after_delivery";
	    }
            return null;
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
package com.cs.srs.model.data;

import java.util.HashMap;
import com.cs.srs.model.data.Item.State;

public class BuyingItem extends SRSData {
    private String count;
    private String account;
    private String state;
    private String members_id;
    private String retailer_items_id;

    public BuyingItem(int id, int count, String account, State state, int members_id, int retailer_items_id) {
	super(id);
	setCount(count);
	setAccount(account);
	setState(state);
	setMembersId(members_id);
	setRetailerItemsId(retailer_items_id);
    }

    public BuyingItem(int count, String account, State state, int members_id, int retailer_items_id) {
	this(0, count, account, state, members_id, retailer_items_id);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), count, account, state, members_id, retailer_items_id };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("count", count);
	pair.put("account", account);
	pair.put("state", state);
	pair.put("members_id", members_id);
	pair.put("retailer_items_id", retailer_items_id);
	
	return pair;
    }

    public void setCount(int count) {
	this.count = count + "";
    }

    public int getCount() {
	return Integer.parseInt(count);
    }

    public void setAccount(String account) {
	this.account = getDQuoteString(account);
    }

    public String getAccount() {
	return getDQuoteFreeString(account);
    }

    public void setState(State state) {
	this.state = getDQuoteString(state.toString());
    }

    public State getState() {
	return State.toState(getDQuoteFreeString(state));
    }

    public void setMembersId(int members_id) {
	this.members_id = "" + members_id;
    }
    
    public int getMembersId() {
	return Integer.parseInt(members_id);
    }

    public void setRetailerItemsId(int retailer_items_id) {
	this.retailer_items_id = "" + retailer_items_id;
    }

    public int getRetailerItemsId() {
	return Integer.parseInt(retailer_items_id);
    }
}
package com.cs.srs.model.data;

import java.util.HashMap;
import com.cs.srs.model.data.Item.State;

public class BuyingRetailerItem extends SRSData {
    private String count;
    private String account;
    private String state;
    private String members_id;
    private String wholesaler_items_id;

    public BuyingRetailerItem(int id, int count, String account, State state, int members_id, int wholesaler_items_id) {
	super(id);
	setCount(count);
	setAccount(account);
	setState(state);
	setMembersId(members_id);
	setWholesalerItemsId(wholesaler_items_id);
    }

    public BuyingRetailerItem(int count, String account, State state, int members_id, int wholesaler_items_id) {
	this(0, count, account, state, members_id, wholesaler_items_id);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), count, account, state, members_id, wholesaler_items_id };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("count", count);
	pair.put("account", account);
	pair.put("state", state);
	pair.put("members_id", members_id);
	pair.put("wholesaler_items_id", wholesaler_items_id);
	
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
	this.state = state.toString();
    }

    public String getState() {
	return state;
    }

    public void setMembersId(int members_id) {
	this.members_id = "" + members_id;
    }
    
    public int getMembersId() {
	return Integer.parseInt(members_id);
    }

    public void setWholesalerItemsId(int wholesaler_items_id) {
	this.wholesaler_items_id = "" + wholesaler_items_id;
    }

    public int getWholesalerItemsId() {
	return Integer.parseInt(wholesaler_items_id);
    }
}
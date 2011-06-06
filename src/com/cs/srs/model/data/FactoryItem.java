package com.cs.srs.model.data;

import java.util.HashMap;

public class FactoryItem extends SRSData {
    private String count;
    private String items_id;

    public FactoryItem(int id, int count, int items_id) {
	super(id);
	setCount(count);
	setItemsId(items_id);
    }

    public FactoryItem(int count, int items_id) {
	this(0, count, items_id);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), count, items_id };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("count", count);
	pair.put("items_id", items_id);
	
	return pair;
    }

    public void setCount(int count) {
	this.count = count + "";
    }

    public int getCount() {
	return Integer.parseInt(count);
    }

    public void setItemsId(int items_id) {
	this.items_id = items_id + "";
    }

    public int getItemsId() {
	return Integer.parseInt(items_id);
    }
}
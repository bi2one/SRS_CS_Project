package com.cs.srs.model.data;

import java.util.HashMap;

public class ConsumerItem extends SRSData {
    private String count;
    private String desc_head;
    private String items_id;

    public ConsumerItem(int id, int count, String desc_head, int items_id) {
	super(id);
	setCount(count);
	setDescHead(desc_head);
	setItemsId(items_id);
    }

    public ConsumerItem(int count, String desc_head, int items_id) {
	this(0, count, desc_head, items_id);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), count, desc_head, items_id };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("count", count);
	pair.put("desc_head", desc_head);
	pair.put("items_id", items_id);
	
	return pair;
    }

    public void setCount(int count) {
	this.count = count + "";
    }

    public int getCount() {
	return Integer.parseInt(count);
    }

    public void setDescHead(String desc_head) {
	this.desc_head = getDQuoteString(desc_head);
    }

    public String getDescHead() {
	return getDQuoteFreeString(desc_head);
    }

    public void setItemsId(int items_id) {
	this.items_id = items_id + "";
    }

    public int getItemsId() {
	return Integer.parseInt(items_id);
    }
}
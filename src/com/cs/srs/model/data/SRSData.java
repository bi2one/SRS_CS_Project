package com.cs.srs.model.data;

import java.util.HashMap;

public abstract class SRSData {
    private String id;
    
    public abstract HashMap<String, String> getValuePair();
    public abstract String[] getValueTuple();

    public SRSData(int id) {
	setId(id);
    }

    protected String getRawId() {
	return id;
    }

    public void setId(int id) {
	if (id == 0)
	    this.id = "null";
	else
	    this.id = id + "";
    }

    public int getId() {
	if (!id.equals("null"))
	    return Integer.parseInt(id);
	else
	    return 0;
    }

    public String getDQuoteString(String base) {
	return "\"" + base + "\"";
    }

    public String getDQuoteFreeString(String base) {
	return base.substring(1, base.length() - 1);
    }
}
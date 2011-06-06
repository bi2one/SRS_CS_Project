package com.cs.srs.model.data;

import java.util.HashMap;

public class Report extends SRSData {
    private String filename;
    private String members_id;

    public Report(int id, String filename, int members_id) {
	super(id);
	setFilename(filename);
	setMembersId(members_id);
    }

    public Report(String filename, int members_id) {
	this(0, filename, members_id);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), filename, members_id };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("filename", filename);
	pair.put("members_id", members_id);
	return pair;
    }

    public void setFilename(String filename) {
	this.filename = getDQuoteString(filename);
    }

    public void setMembersId(int members_id) {
	this.members_id = "" + members_id;
    }

    public String getFilename() {
	return getDQuoteFreeString(filename);
    }

    public int getMembersId() {
	return Integer.parseInt(members_id);
    }
}
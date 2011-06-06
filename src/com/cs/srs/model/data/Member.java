package com.cs.srs.model.data;

import java.util.HashMap;

public class Member extends SRSData {
    private String kind;
    private String username;
    private String password;

    public enum Kind {
	CONSUMER, WHOLESALER, RETAILER, FACTORY;
	public String toString() {
	    switch(this) {
	    case CONSUMER:
		return "consumer";
	    case WHOLESALER:
		return "wholesaler";
	    case RETAILER:
		return "retailer";
	    case FACTORY:
		return "factory";
	    }
            return null;
	}
    };

    public Member(int id, Kind kind, String username, String password) {
	super(id);
	setKind(kind);
	setUsername(username);
	setPassword(password);
    }

    public Member(Kind kind, String username, String password) {
	this(0, kind, username, password);
    }

    public String[] getValueTuple() {
	String[] tuple = { getRawId(), kind, username, password };
	return tuple;
    }

    public HashMap<String, String> getValuePair() {
	HashMap<String, String> pair = new HashMap<String, String>();
	pair.put("kind", kind);
	pair.put("username", username);
	pair.put("password", password);
	return pair;
    }

    public void setKind(Kind kind) {
	this.kind = getDQuoteString(kind.toString());
    }

    public void setUsername(String username) {
	this.username = getDQuoteString(username);
    }

    public void setPassword(String password) {
	this.password = getDQuoteString(password);
    }

    public String getKind() {
	return getDQuoteFreeString(kind);
    }

    public String getUsername() {
	return getDQuoteFreeString(username);
    }

    public String getPassword() {
	return getDQuoteFreeString(password);
    }
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.Item;

public class ItemModel extends Model {
    public ItemModel() {
	super("items");
    }

    public Item findItemById(int id) {
	ResultSet result = super.findById(id);
	try {
	    if (result.next()) {
		return new Item(result.getInt("id"),
				result.getString("name"),
				result.getInt("price"),
				result.getString("description"));
	    } else {
		return null;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.SRSData;
import com.cs.srs.model.data.Item;

public class ItemModel extends Model {
    public ItemModel() {
	super("items");
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new Item(result.getInt("id"),
			result.getString("name"),
			result.getInt("price"),
			result.getString("description"));
    }

    public boolean updateItemPrice(int id, int price) {
	Item item = ((Item)findItemById(id));
	item.setPrice(price);
	return save(item);
    }
}
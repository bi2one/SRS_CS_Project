package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.ConsumerItem;

public class ConsumerItemModel extends Model {
    public ConsumerItemModel() {
	super("consumer_items");
    }

    public ArrayList<ConsumerItem> findAllItem() {
	ArrayList<ConsumerItem> items = new ArrayList<ConsumerItem>();
	ResultSet result = super.findAll();

	try {
	    while(result.next()) {
		ConsumerItem item = new ConsumerItem(result.getInt("id"),
						     result.getInt("count"),
						     result.getString("desc_head"),
						     result.getInt("items_id"));
		items.add(item);
	    }
	} catch(SQLException e) {
	    e.printStackTrace();
	}
	
	return items;
    }
}
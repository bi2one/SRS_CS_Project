package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.RetailerItem;
import com.cs.srs.model.data.SRSData;

public class RetailerItemModel extends Model {
    public RetailerItemModel() {
	super("retailer_items");
    }
    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new RetailerItem(result.getInt("count"),
				result.getInt("items_id"));
    }    
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.FactoryItem;
import com.cs.srs.model.data.SRSData;

public class FactoryItemModel extends Model {
    public static final String TABLE = "factory_items";
    public static final String TN_COUNT = "count";
    public static final String TN_ITEMS_ID = "items_id";

    
    public FactoryItemModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new FactoryItem(result.getInt(TN_COUNT),
			       result.getInt(TN_ITEMS_ID));
    }    
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.data.WholesalerItem;
import com.cs.srs.model.data.SRSData;

public class WholesalerItemModel extends Model {
    public static final String TABLE = "wholesaler_items";
    public static final String TN_COUNT = "count";
    public static final String TN_ITEMS_ID = "items_id";
    
    public WholesalerItemModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new WholesalerItem(result.getInt(TN_COUNT),
				  result.getInt(TN_ITEMS_ID));
    }

    public boolean updateItemCount(int id, int count) {
	WholesalerItem item = ((WholesalerItem)findItemById(id));
	item.setCount(count);
	return save(item);
    }    
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.ConsumerItem;
import com.cs.srs.model.data.SRSData;

public class ConsumerItemModel extends Model {
    public static final String TN_COUNT = "count";
    public static final String TN_DESC_HEAD = "desc_head";
    public static final String TN_ITEMS_ID = "items_id";
    
    public ConsumerItemModel() {
	super("consumer_items");
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new ConsumerItem(result.getInt(TN_COUNT),
				result.getString(TN_DESC_HEAD),
				result.getInt(TN_ITEMS_ID));
    }

    public boolean updateItemPrice(int id, int price) {
	ItemModel iModel = new ItemModel();
	ConsumerItem item = ((ConsumerItem)findItemById(id));
	return iModel.updateItemPrice(item.getItemsId(), price);
    }

    public boolean updateItemCount(int id, int count) {
	ConsumerItem item = ((ConsumerItem)findItemById(id));
	item.setCount(count);
	return save(item);
    }
    
    public boolean updateSoldOut(int id) {
	return updateItemCount(id, 0);
    }
}
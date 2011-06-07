package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.BuyingItem;
import com.cs.srs.model.data.SRSData;
import com.cs.srs.model.data.Item.State;

public class BuyingItemModel extends Model {
    public static final String TABLE = "buying_items";
    public static final String TN_COUNT = "count";
    public static final String TN_ACCOUNT = "account";
    public static final String TN_STATE = "state";
    public static final String TN_MEMBERS_ID = "members_id";
    public static final String TN_RETAILER_ITEMS_ID = "retailer_items_id";
    
    public BuyingItemModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new BuyingItem(result.getInt(TN_COUNT),
			      result.getString(TN_ACCOUNT),
			      State.toState(result.getString(TN_STATE)),
			      result.getInt(TN_MEMBERS_ID),
			      result.getInt(TN_RETAILER_ITEMS_ID));
    }

    public ArrayList<SRSData> findItemByMemberId(int members_id) {
	return simpleFindItem(TN_MEMBERS_ID, "" + members_id, "id", true);
    }

    public void order(int count, String account, int members_id, int retailer_items_id) {
	save(new BuyingItem(count, account, State.BEFORE_PAYMENT, members_id, retailer_items_id));
    }

    public ArrayList<SRSData> findRefundItems() {
	return simpleFindItem(TN_STATE, "\"refund\"", "id", true);
    }

    public boolean updateItemState(int id, State state) {
	BuyingItem item = ((BuyingItem)findItemById(id));
	item.setState(state);
	return save(item);
    }
}
package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.BuyingRetailerItem;
import com.cs.srs.model.data.SRSData;
import com.cs.srs.model.data.Item.State;

public class BuyingRetailerItemModel extends Model {
    public static final String TABLE = "buying_retailer_items";
    public static final String TN_COUNT = "count";
    public static final String TN_ACCOUNT = "account";
    public static final String TN_STATE = "state";
    public static final String TN_MEMBERS_ID = "members_id";
    public static final String TN_WHOLESALER_ITEMS_ID = "wholesaler_items_id";
    
    public BuyingRetailerItemModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new BuyingRetailerItem(result.getInt(TN_COUNT),
				      result.getString(TN_ACCOUNT),
				      State.toState(result.getString(TN_STATE)),
				      result.getInt(TN_MEMBERS_ID),
				      result.getInt(TN_WHOLESALER_ITEMS_ID));
    }

    public ArrayList<SRSData> findItemByMemberId(int members_id) {
	return simpleFindItem(TN_MEMBERS_ID, "" + members_id, "id", true);
    }

    public void order(int count, String account, int members_id, int wholesaler_items_id) {
	save(new BuyingRetailerItem(count, account, State.BEFORE_PAYMENT, members_id, wholesaler_items_id));
    }
}
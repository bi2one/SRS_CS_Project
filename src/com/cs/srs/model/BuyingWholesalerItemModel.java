package com.cs.srs.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cs.srs.model.data.BuyingWholesalerItem;
import com.cs.srs.model.data.SRSData;
import com.cs.srs.model.data.Item.State;

public class BuyingWholesalerItemModel extends Model {
    public static final String TABLE = "buying_wholesaler_items";
    public static final String TN_COUNT = "count";
    public static final String TN_ACCOUNT = "account";
    public static final String TN_STATE = "state";
    public static final String TN_MEMBERS_ID = "members_id";
    public static final String TN_FACTORY_ITEMS_ID = "factory_items_id";
	
    
    public BuyingWholesalerItemModel() {
	super(TABLE);
    }

    protected SRSData createDataByResultSet(ResultSet result) throws SQLException {
	return new BuyingWholesalerItem(result.getInt(TN_COUNT),
					result.getString(TN_ACCOUNT),
					State.toState(result.getString(TN_STATE)),
					result.getInt(TN_MEMBERS_ID),
					result.getInt(TN_FACTORY_ITEMS_ID));
    }

    public void order(int count, String account, int members_id, int factory_items_id) {
	save(new BuyingWholesalerItem(count, account, State.BEFORE_PAYMENT, members_id, factory_items_id));
    }

    public ArrayList<SRSData> findItemByMemberId(int members_id) {
	return simpleFindItem(TN_MEMBERS_ID, "" + members_id, "id", true);
    }
}
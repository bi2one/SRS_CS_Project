// import com.cs.srs.control.Control_consumer;
import com.cs.srs.model.Model;
import com.cs.srs.model.MemberModel;
import com.cs.srs.model.data.Member;
import com.cs.srs.model.data.Member.Kind;

import com.cs.srs.model.*;
import com.cs.srs.model.data.*;

import java.util.HashMap;
import java.util.ArrayList;

public class ModelTestDrive {
    public static void main(String[] args) {
	/* insert example */
	// Model model = new Model("items");
	// String[] values = { "null", "\"ddd\"", "1000", "\"description\"" };
	// model.insert(values);


	/* updateById example */
	// Model model = new Model("items");
	// HashMap<String, String> valuePairs = new HashMap<String, String>();

	// valuePairs.put("id", "4");
	// valuePairs.put("name", "\"eee\"");
	// valuePairs.put("price", "2000");
	// model.updateById(valuePairs, 4);

	/* MemberModel Test - save */
	// Member member = new Member(Kind.CONSUMER, "testconfig!", "testpassafdsaffadsfsa");
	// MemberModel model = new MemberModel();
	// model.save(member);

	/* ItemModel Test - save */
	// Item item = new Item("tv", 2000, "tv for show!");
	// member.setId(3);
	// ItemModel model = new ItemModel();
	// model.save(item);

	/* ItemModel Test - find */
	// ItemModel model = new ItemModel();
	// Item item = (Item)(model.findItemById(3));
	// System.out.println(item.getName());

	/* ConsumerItemModel Test - save */
	// ConsumerItemModel cModel = new ConsumerItemModel();
	// ConsumerItem item1 = new ConsumerItem(1, "abcd", 1);
	// ConsumerItem item2 = new ConsumerItem(10, "abcde", 2);
	// ConsumerItem item3 = new ConsumerItem(100, "abcdef", 4);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);
	
	/* ConsumerItemModel Test - findAllItem */
	// ConsumerItemModel model = new ConsumerItemModel();
	// ItemModel iModel = new ItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     Item i = (Item)(iModel.findItemById(((ConsumerItem)item).getItemsId()));
	//     System.out.println(i.getName());
	// }

	/* BuyingItemModel Test - save */
	// BuyingItemModel cModel = new BuyingItemModel();
	// BuyingItem item1 = new BuyingItem(1, "account11", Item.State.REFUND, 1, 1);
	// BuyingItem item2 = new BuyingItem(10, "account21", Item.State.REFUND, 2, 2);
	// BuyingItem item3 = new BuyingItem(100, "account31", Item.State.REFUND, 1, 3);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);

	/* BuyingItemModel Test - remove */
	// BuyingItemModel cModel = new BuyingItemModel();
	// BuyingItem item1 = new BuyingItem(1, "account1", Item.State.ACCEPT, 1, 1);
	// cModel.remove(item1);
	// cModel.remove(1);
	// cModel.remove("account", "\"account3\"");

	/* BuyingItemModel Test - order */
	// BuyingItemModel cModel = new BuyingItemModel();
	// cModel.order(10, "account10", 2, 1);

	/* BuyingItemModel Test - findRefundItems */
	// BuyingItemModel cModel = new BuyingItemModel();
	// ArrayList<SRSData> items = cModel.findRefundItems();
	// for (SRSData item : items) {
	//     System.out.println(((BuyingItem)item).getAccount());
	// }

	/* BuyingItemModel Test - findAllItem */
	// BuyingItemModel model = new BuyingItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     System.out.println(((BuyingItem)item).getAccount());
	// }

	/* BuyingItemModel Test - findItemByMemberId */
	// BuyingItemModel model = new BuyingItemModel();
	// ArrayList<SRSData> items = model.findItemByMemberId(1);
	// for (SRSData item : items) {
	//     System.out.println(((BuyingItem)item).getAccount());
	// }

	/* BuyingItemModel Test - updateItemState */
	// BuyingItemModel model = new BuyingItemModel();
	// model.updateItemState(5, Item.State.ARRIVAL);

	/* ConsumerItemModel Test - updateItemPrice */
	// ConsumerItemModel model = new ConsumerItemModel();
	// model.updateItemPrice(2, 20000);
	
	/* ConsumerItemModel Test - updateSoldOut */
	// ConsumerItemModel model = new ConsumerItemModel();
	// model.updateSoldOut(2);

	/* BuyingRetailerItemModel Test - save */
	// BuyingRetailerItemModel cModel = new BuyingRetailerItemModel();
	// BuyingRetailerItem item1 = new BuyingRetailerItem(1, "account11", Item.State.REFUND, 1, 1);
	// BuyingRetailerItem item2 = new BuyingRetailerItem(10, "account21", Item.State.ACCEPT, 2, 2);
	// BuyingRetailerItem item3 = new BuyingRetailerItem(100, "account31", Item.State.BEFORE_PAYMENT, 1, 3);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);

	/* BuyingRetailerItemModel Test - findAllItem */
	// BuyingRetailerItemModel model = new BuyingRetailerItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     System.out.println(((BuyingRetailerItem)item).getAccount());
	// }

	/* BuyingRetailerItemModel Test - findItemByMemberId */
	// BuyingRetailerItemModel model = new BuyingRetailerItemModel();
	// ArrayList<SRSData> items = model.findItemByMemberId(1);
	// for (SRSData item : items) {
	//     System.out.println(((BuyingRetailerItem)item).getAccount());
	// }

	/* WholesalerItemModel Test - save */
	// WholesalerItemModel cModel = new WholesalerItemModel();
	// WholesalerItem item1 = new WholesalerItem(1, 1);
	// WholesalerItem item2 = new WholesalerItem(10, 2);
	// WholesalerItem item3 = new WholesalerItem(100, 3);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);

	/* WholesalerItemModel Test - findAllItem */
	// WholesalerItemModel model = new WholesalerItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     System.out.println(((WholesalerItem)item).getCount());
	// }

	/* WholesalerItemModel Test - updateItemCount */
	// WholesalerItemModel model = new WholesalerItemModel();
	// model.updateItemCount(1, 1000);

	/* BuyingWholesalerItemModel Test - save */
	// BuyingWholesalerItemModel cModel = new BuyingWholesalerItemModel();
	// BuyingWholesalerItem item1 = new BuyingWholesalerItem(1, "account11", Item.State.ACCEPT, 1, 1);
	// BuyingWholesalerItem item2 = new BuyingWholesalerItem(10, "account21", Item.State.ACCEPT, 2, 2);
	// BuyingWholesalerItem item3 = new BuyingWholesalerItem(100, "account31", Item.State.BEFORE_PAYMENT, 1, 3);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);

	/* BuyingWholesalerItemModel Test - order */
	// BuyingWholesalerItemModel cModel = new BuyingWholesalerItemModel();
	// cModel.order(10, "account10", 2, 1);

	/* BuyingWholesalerItemModel Test - findAllItem */
	// BuyingWholesalerItemModel model = new BuyingWholesalerItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     System.out.println(((BuyingWholesalerItem)item).getAccount());
	// }

	/* BuyingRetailerItemModel Test - findItemByMemberId */
	// BuyingWholesalerItemModel model = new BuyingWholesalerItemModel();
	// ArrayList<SRSData> items = model.findItemByMemberId(1);
	// for (SRSData item : items) {
	//     System.out.println(((BuyingWholesalerItem)item).getAccount());
	// }

	/* FactoryItemModel Test - save */
	// FactoryItemModel cModel = new FactoryItemModel();
	// FactoryItem item1 = new FactoryItem(1, 1);
	// FactoryItem item2 = new FactoryItem(10, 2);
	// FactoryItem item3 = new FactoryItem(100, 3);
	// cModel.save(item1);
	// cModel.save(item2);
	// cModel.save(item3);

	/* FactoryItemModel Test - findAllItem */
	// FactoryItemModel model = new FactoryItemModel();
	// ArrayList<SRSData> items = model.findAllItem();
	// for (SRSData item : items) {
	//     System.out.println(((FactoryItem)item).getCount());
	// }
	
	/* MemberModel Test - findItemByKind */
	MemberModel model = new MemberModel();
	ArrayList<SRSData> items = model.findItemByKind(Member.Kind.CONSUMER);
	for (SRSData item : items) {
	    System.out.println(((Member)item).getUsername());
	}
	

	
	

	

	/* control_consumer Test - data handling */
    	// Control_consumer cc = new Control_consumer(0) {
			
	// 		protected boolean showSellItems(int retailerItemId, String name, int value) {
	// 			System.out.println("name : " + name + " : " + value);
	// 			return true;
	// 		}
	// 		protected boolean showBuyingItems(int id, String name, int value) {
	// 			System.out.println("name : " + name + " : " + value);
	// 			return true;
	// 		}
	// 	};
		
	// 	cc.getAllItems();
	// 	Item i = cc.showItemDescription(1);
	// 	System.out.println("i.getName() : " + i.getName());
	// 	cc.Order(1, 3);
	// 	cc.getBuyingItems();
	// 	cc.CancelOrder(13);
	// 	cc.getBuyingItems();
    }
}

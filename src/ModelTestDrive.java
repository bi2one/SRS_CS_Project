import com.cs.srs.control.Control_consumer;
import com.cs.srs.model.Model;
import com.cs.srs.model.MemberModel;
import com.cs.srs.model.data.Member;
import com.cs.srs.model.data.Member.Kind;

import com.cs.srs.model.ItemModel;
import com.cs.srs.model.data.Item;

import java.util.HashMap;

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
//	ItemModel model = new ItemModel();
//	Item item = model.findItemById(3);
//	System.out.println(item.getName());
    	
    	Control_consumer cc = new Control_consumer(0) {
			
			protected boolean showSellItems(int retailerItemId, String name, int value) {
				System.out.println("name : " + name + " : " + value);
				return true;
			}
			protected boolean showBuyingItems(int id, String name, int value) {
				System.out.println("name : " + name + " : " + value);
				return true;
			}
		};
		
		cc.getAllItems();
		Item i = cc.showItemDescription(1);
		System.out.println("i.getName() : " + i.getName());
		cc.Order(1, 3);
		cc.getBuyingItems();
		cc.CancelOrder(13);
		cc.getBuyingItems();
    }
}

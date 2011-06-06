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
	Member member = new Member(Kind.CONSUMER, "testconfig!", "testpassafdsaffadsfsa");
	MemberModel model = new MemberModel();
	model.save(member);

	/* ItemModel Test - save */
	// Item item = new Item("tv", 2000, "tv for show!");
	// member.setId(3);
	// ItemModel model = new ItemModel();
	// model.save(item);
    }
}

import com.cs.srs.model.Model;

public class ModelTestDrive {
    public static void main(String[] args) {
	Model model = new Model("items");
	model.update("INSERT INTO items(name, price, description) VALUES (\"ccc\", 1000, \"\");");
    }
}

package Items;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuItem {
	
	public String article;
	public String name;
	public String category;
	public String img;
	public String description;
	public double price;
	
	public MenuItem(JSONObject json) throws JSONException, MalformedURLException {
		article = json.getString("article");
		category = json.getString("category");
		name = json.getString("name");
		img =json.getString("img");
		description = json.getString("description");
		price = json.getDouble("price");
	}
	
	
	public MenuItem(String _article, String _name, String _category, String _img, String _description, double _price) {
		article = _article;
		name = _name;
		category = _category;
		img = _img;
		description = _description;
		price = _price;
		
	}
	
	public JSONObject toJSONObject() throws JSONException {
		JSONObject ob = new JSONObject();
			ob.put("article", article);
			ob.put("category", category);
			ob.put("img", img);
			ob.put("description", description);
			ob.put("price", price);
			ob.put("name", name);
			return ob;
	}
	
	@Override
	public String toString() {
		String s = article + ' ' + name + ' ' + category + ' ' + img + ' ' + description + ' ' + price;
		return s;
	}
	
}

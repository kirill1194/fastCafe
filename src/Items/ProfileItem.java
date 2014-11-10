package Items;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileItem {
	public String name;
	public String phone;
	public String sale;
	
	public ProfileItem(String _name, String _phone) {
		name = _name;
		phone = _phone;
	}
	
	public JSONObject toJSONObject() {
		JSONObject result = new JSONObject();
		try {
			result.put("name", name);
			result.put("phone", phone);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

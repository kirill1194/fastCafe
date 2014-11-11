package serverPackege;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Exceptions.ExceptionProcessing;
import Exceptions.RequestException;
import Exceptions.SQLWorkException;
import Items.MenuItem;
import SQL.SQLClasses;

/**
 * 
 * @author Kirill
 * @parameters: "category"
 * @return: "response" - JSONArray MenuItem
 *
 */

@WebServlet("/getMenuByCategory")
public class GetMenuByCategory extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		
		String category = getParameter(request, CATEGORY);
		
		ArrayList<MenuItem> arrayRequest = null;
		try {
			arrayRequest = SQLClasses.getMenuByCategory(category);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		JSONArray arr = new JSONArray();
		for (int i=0; i<arrayRequest.size(); i++)
			try {
				arr.put(arrayRequest.get(i).toJSONObject());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		JSONObject JSONResponse = new JSONObject();
		try {
			JSONResponse.put(RESPONSE, arr);
		} catch (JSONException e) {
			throw new RequestException(500, "JSON Exception");
		}
		return JSONResponse;
	}

}

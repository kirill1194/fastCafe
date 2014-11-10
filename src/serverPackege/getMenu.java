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
 * @parameters:
 * @return: "response" - JSONArray MenuItem
 */
@WebServlet("/getMenu")
public class getMenu extends BaseServer{


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		ArrayList<MenuItem> arrayRequest = null;
		try {
			arrayRequest = SQLClasses.getMenu();
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

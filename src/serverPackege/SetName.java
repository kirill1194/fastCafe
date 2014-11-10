package serverPackege;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import Exceptions.ExceptionProcessing;
import Exceptions.RequestException;
import Exceptions.SQLWorkException;
import SQL.SQLClasses;

/**
 * 
 * @author Kirill
 * @parameters: "name", "access_token"
 * @return: "response" - true/false
 */

@WebServlet("/setName")
public class SetName extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		String name = getParameter(request, NAME);
		
		String accessToken = getParameter(request, ACCESS_TOKEN);
		boolean SQLResponse = false;
		try {
			SQLResponse = SQLClasses.setName(accessToken, name);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		
		JSONObject JSONResponse = new JSONObject();
		try {
			JSONResponse.put(RESPONSE, Boolean.toString(SQLResponse));
		} catch (JSONException e) {
			throw new RequestException(500, "");
		}
		
		return JSONResponse;
	}

}

package serverPackege;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import Exceptions.ExceptionProcessing;
import Exceptions.RequestException;
import Exceptions.SQLWorkException;
import SQL.SQLClasses;

/**
 * 
 * @author Kirill
 * @parameters: "access_token"
 * @return: "response" - время жизни токена
 */

@WebServlet("/LifeTimeAccessToken")
public class LifeTimeAccessToken extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		
		String accessToken = getParameter(request, ACCESS_TOKEN);
		
		int SQLResponse = 0;
		try {
			SQLResponse = SQLClasses.LifeTimeAccessToken(accessToken);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put(RESPONSE, Integer.toString(SQLResponse));
		
		JSONObject JSONResponse = new JSONObject(parameters);
		
		return JSONResponse;
	}

}

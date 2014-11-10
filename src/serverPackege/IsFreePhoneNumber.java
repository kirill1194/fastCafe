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
 * @parameters: "phone"
 * @return: "response" - true/false
 */

@WebServlet("/IsFreePhoneNumber")
public class IsFreePhoneNumber extends BaseServer {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected JSONObject work(HttpServletRequest request) throws RequestException {
		String phone = getParameter(request, PHONE);
		
		boolean boolResponse = false;
		try {
			boolResponse = SQLClasses.isFreeUserName(phone);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put(RESPONSE, Boolean.toString(boolResponse));
		JSONObject JSONResponse = new JSONObject(parameters);
		return JSONResponse;
	}
}

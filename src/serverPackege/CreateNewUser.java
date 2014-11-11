package serverPackege;

import java.util.TreeMap;

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
 * @parameters: "phone", "pass"
 * @return: "response" - true/false
 *
 */

@WebServlet("/createNewUser")
public class CreateNewUser extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request) 
			throws RequestException {
		String phone = getParameter(request, PHONE);
		
		String pass = getParameter(request, PASS); 
		
		boolean SQLResponse = false;
		try {
			SQLResponse = SQLClasses.createNewUser(phone, pass);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put(RESPONSE, Boolean.toString(SQLResponse));
		JSONObject JSONResponse = new JSONObject(parameters);
		return JSONResponse;
	}

	

}

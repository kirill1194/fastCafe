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
 * @parameters: "pnome", "pass"
 * @return: "access_token" - Access Token
 * @return: "successfuly" - true/false
 */

@WebServlet("/login")
public class Login extends BaseServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		String phone = getParameter(request, PHONE);
		
		String pass = getParameter(request, PASS);
		
		boolean successfully = true;
		String SQLResponse = null;
		try {
			SQLResponse = SQLClasses.login(phone, pass);
			if (SQLResponse == null) {
				successfully = false;
				SQLResponse = "";
			}
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put(SUCCESSFULLY, Boolean.toString(successfully));
		parameters.put(ACCESS_TOKEN, SQLResponse);
		JSONObject JSONResponse = new JSONObject(parameters);
		return JSONResponse;
	}

}

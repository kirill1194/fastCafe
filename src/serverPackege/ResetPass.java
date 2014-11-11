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
 * @parameters: "phone"
 * @return: "successfuly" - true/false
 */

@WebServlet("/resetPass")
public class ResetPass extends BaseServer{


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		String phone = getParameter(request, PHONE);
		boolean SQLResponse = false;
		try {
			SQLResponse = SQLClasses.resetPass(phone);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		
		JSONObject JSONResponse = new JSONObject();
		try {
			JSONResponse.put(SUCCESSFULLY, Boolean.toString(SQLResponse));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JSONResponse;
	}

}

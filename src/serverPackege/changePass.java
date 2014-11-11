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
 * @paramteres: "old_pass", "new_pass", "access_token"
 * @return: "successfully" - true/false
 */
@WebServlet("/changePass")
public class changePass extends BaseServer {

	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		String oldPass = getParameter(request, OLD_PASS);
		String newPass = getParameter(request, NEW_PASS);
		String accessToken = getParameter(request, ACCESS_TOKEN);
		
		boolean SQLResponse = false;
		try {
			SQLResponse = SQLClasses.changePass(oldPass, newPass, accessToken);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		
		JSONObject JSONResponse = new JSONObject();
		try {
			JSONResponse.put(SUCCESSFULLY, Boolean.toString(SQLResponse));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONResponse;
	}

}

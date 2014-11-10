package serverPackege;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import Exceptions.ExceptionProcessing;
import Exceptions.RequestException;
import Exceptions.SQLWorkException;
import Items.ProfileItem;
import SQL.SQLClasses;

/**
 * 
 * @author Kirill
 * @parameters: "access_token"
 * @return: JSONObject Profile
 */

@WebServlet("/getProfile")
public class getProfile extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		String accessToken = getParameter(request, ACCESS_TOKEN);
//		String accessToken = request.getParameter("access_token");
//		if (accessToken == null) 
//			throw new RequestException(400, NFP + "access_token");
		ProfileItem SQLResponse = null;
		try {
			SQLResponse = SQLClasses.getProfile(accessToken);
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		JSONObject JSONResponse = SQLResponse.toJSONObject();
		return JSONResponse;
	}

}

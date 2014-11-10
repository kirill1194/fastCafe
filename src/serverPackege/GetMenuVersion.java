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
 * @parameter:
 * @return "response" - версия меню
 */
@WebServlet("/getMenuVersion")
public class GetMenuVersion extends BaseServer {


	private static final long serialVersionUID = 1L;

	@Override
	protected JSONObject work(HttpServletRequest request)
			throws RequestException {
		int SQLResponse = -1;
		try {
			SQLResponse = SQLClasses.getMenuVersion();
		} catch (SQLWorkException e) {
			ExceptionProcessing.processingSQLWorkException(e);
		}
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put(RESPONSE, Integer.toString(SQLResponse));
		JSONObject JSONResponse = new JSONObject(parameters);
		return JSONResponse;
	}

}

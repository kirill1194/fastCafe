package serverPackege;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Exceptions.RequestException;

public abstract class BaseServer extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String SQLERR = "SQL Error: ";
	public final static String RESPONSE = "response"; 
	public final static String NFP = "not found parameter ";
	public final static String PHONE = "phone";
	public final static String PASS = "pass";
	public final static String ACCESS_TOKEN = "access_token";
	public final static String SUCCESSFULLY = "successfully";
	public final static String NAME = "name";
	public final static String OLD_PASS = "old_pass";
	public final static String NEW_PASS = "new_pass";
	public final static String CATEGORY = "category";
	
	
	@Override
	public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		processing(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		processing(request, response);
	}
	
	private void processing(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			JSONObject JSONResponse = work(request);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(JSONResponse.toString());
		} catch (RequestException e) {
			response.sendError(e.getErrorCode(), e.getMessage());
		}
	}

	protected abstract JSONObject work(HttpServletRequest request) throws RequestException;
	
	protected String getParameter(HttpServletRequest request, String parameter) throws RequestException{
		String result = request.getParameter(parameter);
		if (result == null)
			throw new RequestException(400, NFP + "\"" + parameter + "\"");
		return result;
	}
}

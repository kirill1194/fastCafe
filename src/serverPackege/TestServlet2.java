//package serverPackege;
//
//import java.io.*;
//import java.util.Map;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.*;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import Exceptions.RequestException;
//import Server.CommandWork;
//import coreservlets.*;
//
///** Simple servlet for testing. Makes use of a helper class. */
//
//@WebServlet("/test-with-util")
//public class TestServlet2 extends HttpServlet {
//  /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	
//	private void processing(HttpServletRequest request,
//                    HttpServletResponse response)
//                    throws ServletException, IOException {
//		response.setContentType("text/html");
//	    PrintWriter out = response.getWriter();
//	    
//	    String command = request.getParameter("command");
//	    if (command == null) return;
//	    if (command.equals("error")) response.sendError(400);
//	    Map <String, String[]> map = request.getParameterMap();
//	    JSONObject JSONResponse = new JSONObject(map);
//	    JSONObject data = new JSONObject();
////	    map.remove(command);
//	    for (String key: map.keySet()) {
//	    	if (key.equals(command)) continue;
//	    	out.println(key + " :");
//	    	StringBuilder value = new StringBuilder();
//	    	for (int i=0; i<map.get(key).length; i++) {
//	    		value.append(map.get(key)[i]);
//	    		out.println('\t' + map.get(key)[i]);
//	    	}
//	    	try {
//				data.put(key, value.toString());
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    }
//	    JSONObject JSONResponse1 = null;;
//		try {
//			JSONResponse1 = CommandWork.work(command, data);
//		} catch (RequestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendError(e.getErrorCode());
//			return;
//		}
//	    out.println(JSONResponse1.toString());
//	    
//	}
//	
//@Override
//  public void doGet(HttpServletRequest request,
//                    HttpServletResponse response)
//      throws ServletException, IOException {
//    processing(request, response);
//  }
//
//	@Override
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//throws ServletException, IOException {
//		processing(request, response);
//	}	
//}

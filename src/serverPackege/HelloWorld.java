

package serverPackege; // Always use packages. Never use default package.

import java.io.*; 
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/** Very simplistic servlet that generates plain text.
 *  Uses the @WebServlet annotation that is supported by
 *  Tomcat 7 and other servlet 3.0 containers. 
 *  
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF 2.x, 
 *  Ajax, jQuery, GWT, Spring, Hibernate/JPA, Hadoop, and Java programming</a>.
 */

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("Hello World");
    out.println("вывод параметра");
    String param = request.getParameter("test");
    out.println(param);
    out.println("eq null: " + param.equals(null));
    out.println("eq zir: " + param.equals(""));
   // request.getAttributeNames();
    String s = "";
    int temp=0;
    for (Enumeration<String> e =  request.getAttributeNames(); e.hasMoreElements();) {
        out.println(e.nextElement().toString());
        temp++;
    }
    out.print(temp);
    out.println(s);
  }
}

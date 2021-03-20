package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class logout extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/Canarabk/logout.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
}

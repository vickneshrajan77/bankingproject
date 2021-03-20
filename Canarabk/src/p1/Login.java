package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String Accno;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 		 
	 {
			 try
			 {
				 String cust=request.getParameter("custid");
				 String pass=request.getParameter("password");
				 Model m = new Model();
				 
				 m.setCustid(cust);
				 m.setPw(pass);
				Boolean status= m.login();
				HttpSession session = request.getSession(true);
				if(status==true)
				{
					Accno=m.getAccno();
					session.setAttribute("Accno", Accno);
					response.sendRedirect("/Canarabk/Home.jsp");
				}
				else
				{
					response.sendRedirect("/Canarabk/Error.jsp");
				}
				 
				 
			 }
			 catch(Exception e)
			 {
				 System.out.println("faiiiiiii");
			 }

}
}


package p1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Changepwd extends HttpServlet 
{
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException 		 
	 {
		String npwd= request.getParameter("npwd");
		HttpSession session = request.getSession();
		String accno=(String) session.getAttribute("Accno");
		System.out.println(accno);
		Model m = new Model();
		m.setPw(npwd);
		m.setAccno(accno);
		try {
			Boolean status = m.changepwd();
			System.out.println(status);
			if(status==true)
			{
				response.sendRedirect("/Canarabk/changesucess.jsp");
			}
			else
			{
				response.sendRedirect("/Canarabk/changefail.jsp");
			}
		} catch (SQLException e) {
			System.out.println("noooo");
		}
	 }
}

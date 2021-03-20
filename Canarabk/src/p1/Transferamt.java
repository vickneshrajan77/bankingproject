package p1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transferamt extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request,HttpServletResponse response ) throws IOException
	{
		HttpSession session = request.getSession();
		String Accno = (String) session.getAttribute("Accno");
		String balance= (String) session.getAttribute("balance");
		 String taccno=request.getParameter("toaccno");
		 String tamt=request.getParameter("tamt");
		Model m= new Model();
		m.setBalance(balance);
		m.setAccno(Accno);
		m.setTaccno(taccno);
		m.setTamt(tamt);
		System.out.println("wgttt");
		try {
			Boolean status1 = m.Transferamt();
			System.out.println(status1);
			
			if(status1==true)
			{
				response.sendRedirect("/Canarabk/Transfersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/Canarabk/Transferfail.jsp");
			}
		} catch (SQLException e) 
		{
			System.out.println("transfer failed");
		}
		
		
		
	}
   
}

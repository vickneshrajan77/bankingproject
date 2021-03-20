package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Balance extends HttpServlet 
{
	private String balance;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException 		 
	 {
		HttpSession session = request.getSession();
		String Accno=(String) session.getAttribute("Accno");
		Model m= new Model();
		m.setAccno(Accno);
		Boolean status=m.checkBalance();
		System.out.println(status);
		if(status==true)
		{
			balance=m.getBalance();
			session.setAttribute("balance", balance);
			response.sendRedirect("/Canarabk/balance.jsp");
		}
		else
		{
			response.sendRedirect("/Canarabk/balancefail.jsp");
		}
		
		
		
	 }
			

}

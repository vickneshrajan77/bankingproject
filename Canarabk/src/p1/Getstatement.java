package p1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Getstatement extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request,HttpServletResponse response ) throws IOException
	{
		HttpSession session=request.getSession();
		String Accno=(String) session.getAttribute("Accno");
		Model m = new Model();
		m.setAccno(Accno);
		try {
			ArrayList al =m.getstatement();
			
			if(al.isEmpty()==true)
			{
				response.sendRedirect("/Canarabk/getfailed.jsp");
			}
			else
			{
				session.setAttribute("al", al);
				response.sendRedirect("/Canarabk/getstatement.jsp");
			}
			
			
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

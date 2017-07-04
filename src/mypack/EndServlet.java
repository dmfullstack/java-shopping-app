package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/end")
public class EndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
		 List<String> items=null;
		 items=(ArrayList)session.getAttribute("cart");
		 
			if(items==null)
			{
				out.print("<h2> No items are selected </h2>");
			}
			else
			{
				out.print("<ul>");
				for(String s:items)
				{
					out.print("<li>"+s+"</li>");
				}
				out.print("</ul>");
				out.print("<br/><a href='http://localhost:8080/shoppingApp/confirm'>Confirm</a><br/>");
				 out.print("<a href='http://localhost:8080/shoppingApp/home.html'>Go To Home</a><br/>");
			}
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

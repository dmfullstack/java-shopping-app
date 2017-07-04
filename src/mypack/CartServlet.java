package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		List<String> items=null;
		HttpSession session=request.getSession();
		items=(ArrayList)session.getAttribute("cart");
		if(items==null)
		{
			items=new ArrayList<String>();
		}
		
		Enumeration<String> pnames=request.getParameterNames();
		while(pnames.hasMoreElements())
		{
			String pname=pnames.nextElement();
			String value=request.getParameter(pname);
			items.add(value);
			out.print(value+" is added to cart<br/>");
		}
		session.setAttribute("cart",items);
		out.print("<br/> There are total "+items.size()+" items in the cart<br/><br/>");
		 out.print("<a href='http://localhost:8080/shoppingApp/home.html'>Go To Home</a><br/>");
		 out.print("<a href='http://localhost:8080/shoppingApp/end'>End Shopping</a><br/>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

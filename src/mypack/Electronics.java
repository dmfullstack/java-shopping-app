package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/electronics")
public class Electronics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 out.print("<form action='http://localhost:8080/shoppingApp/cart'>");
		 out.print("select Electronic appliances:<select name='electronics'>");
		 out.print("<option value='Iron'>Iron</option></br>");
		 out.print("<option value='Gizzer '>Gizzer </option></br>");
		 out.print("<option value='Trimmer'>Trimmer</option></br>");
		 out.print("<option value='Freeze'>Freeze</option></br>");
		 out.print("</select><br/>");
		 out.print("<input type='submit' value='Add to cart'/>");
		 out.print("</form><br/>");
		 out.print("<a href='http://localhost:8080/shoppingApp/home.html'>Go To Home</a><br/>");
		 out.print("<a href='http://localhost:8080/shoppingApp/end'>End Shopping</a><br/>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

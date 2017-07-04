package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServletDB
 */
@WebServlet("/loginDB")
public class LoginServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	Connection con;
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
	} catch (ClassNotFoundException | SQLException e) {		
		e.printStackTrace();
	}
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String id=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			 ps=con.prepareStatement("select * from users where uid=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			boolean flag=false;
			if(rs.next())
			{
				if(rs.getString(2).equals(pwd))
				{
					flag=true;
					out.print("login successfull from database");
					
				}
				if(flag==false)	
				{
					out.print("login failed database value not matched");
				}
			}
			else
			{
				out.print("wrong id");
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

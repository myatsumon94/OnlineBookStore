package test;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import bookStore.model.Books;

/**
 * Servlet implementation class DBTestServlet
 */
public class DBTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/bookStore")
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		Statement stmt = null;
		PrintWriter out= response.getWriter();
		ResultSet books = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			books = stmt.executeQuery("select * from Books;");
			
			while(books.next()) {
				Books book = new Books(
						books.getInt("id"),
						books.getString("author"),
						books.getString("title"),
						books.getString("genre"),
						books.getDouble("price")
						
						);
						
				out.println( book + "\n");		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

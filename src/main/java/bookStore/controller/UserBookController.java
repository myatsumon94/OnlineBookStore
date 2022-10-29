package bookStore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import bookStore.model.BookDAO;
import bookStore.model.Books;

/**
 * Servlet implementation class UserBookController
 */
public class UserBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/bookStore")
	private DataSource dataSource;
	private BookDAO bookDAO;
	
	@Override
	public void init() throws ServletException {
		bookDAO = new BookDAO(dataSource);
		
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showBookList(request, response);
	}

	private void showBookList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Books> bookList = this.bookDAO.getBookList();
		
		request.setAttribute("book_list", bookList);
		RequestDispatcher rd= request.getRequestDispatcher("userIndex.jsp");
		rd.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

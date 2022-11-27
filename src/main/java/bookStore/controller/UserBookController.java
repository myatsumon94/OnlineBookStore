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
		// TODO Auto-generated method stub
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
		
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showBookList(request, response);
			break;
		default:
			showBookList(request, response);
			break;
		}
		
		
	}

	private void showBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Books> bookList = this.bookDAO.getBookList();
	
		request.setAttribute("bookList", bookList);
		RequestDispatcher rd= request.getRequestDispatcher("user-view.jsp");
		rd.forward(request, response);
	
	}
    

//	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//			
//			int id = Integer.parseInt(request.getParameter("id"));
//			Books book = this.bookDAO.getBook(id);
//			
//			request.setAttribute("book", book);
//			RequestDispatcher rd= request.getRequestDispatcher("admin-update.jsp");
//			rd.forward(request, response);
//		
//		}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String mode = request.getParameter("mode");
//		if(mode == null) {
//			mode = "LIST";
//		}
//		switch (mode) {
//		case "LIST":
//			showBookList(request, response);
//			break;
//			
//			
//		case "LOAD":
//			loadBook(request, response);
//			break;
//			
//			
//		case "CREATE":
//			createBook(request, response);
//			break;
//			
//			
//		case "UPDATE":
//			updateBook(request, response);
//			break;
//			
//		case "DELETE":
//			deleteBook(request, response);
//			break;
//			
//		default:
//			showBookList(request, response);
//			break;
//		}
//		
//	}
//    
//    
//
//	private void showBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		List<Books> bookList = this.bookDAO.getBookList();
//	
//		request.setAttribute("bookList", bookList);
//		RequestDispatcher rd= request.getRequestDispatcher("admin-view.jsp");
//		rd.forward(request, response);
//	
//	}
//    
//
//	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//			
//			int id = Integer.parseInt(request.getParameter("id"));
//			Books book = this.bookDAO.getBook(id);
//			
//			request.setAttribute("book", book);
//			RequestDispatcher rd= request.getRequestDispatcher("admin-update.jsp");
//			rd.forward(request, response);
//		
//		}
//	
//	
//	private void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//				
//		
//		String author = request.getParameter("author");
//		String genre = request.getParameter("genre");
//		String title = request.getParameter("title");
//		double price = Double.parseDouble(request.getParameter("price"));
//		
//		
//		Books book = new Books(author, title, genre, price);
//		
//		int rowEffected = this.bookDAO.createBook(book);
//		
//		if(rowEffected > 0)
//			showBookList(request, response);
//		 
//		
//		
//	}
//	
//	
//	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//	
//		int id=Integer.parseInt(request.getParameter("id"));
//		String author = request.getParameter("author");
//		String genre = request.getParameter("genre");
//		String title = request.getParameter("title");
//		double price = Double.parseDouble(request.getParameter("price"));
//		
//		Books book = new Books(id,author, title, genre, price);
//		
//		int rowEffected = this.bookDAO.updateBook(book);
//		
//		if(rowEffected > 0)
//		  showBookList(request, response);
//
//	}
//	
//	
//	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//			int id=Integer.parseInt(request.getParameter("id"));
//			
//			int rowEffected = this.bookDAO.deleteBook(id);
//			
//			if(rowEffected > 0)
//			  showBookList(request, response);
//		}
//	
//
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

package bookStore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import bookStore.model.BookDAO;
import bookStore.model.Books;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Resource(name = "jdbc/bookStore")
	private DataSource dataSource;
	
	private BookDAO bookDAO;
	
	@Override
	public void init() throws ServletException {
		bookDAO = new BookDAO(dataSource);
		
	}
	
	
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		showBookList(request, response);
		
		
		/*String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showBookList(request, response);
			break;
			
		case "LOAD":
			loadBook(request, response);
			break;
			
		case "CREATE":
			createBook(request, response);
			break;
			
		case "UPDATE":
			updateBook(request, response);
			break;
			
		case "DELETE":
			deleteBook(request, response);
			break;
			
		default:
			showBookList(request, response);
			break;
		}
		*/
	}

	private void showBookList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Books> bookList = this.bookDAO.getBookList();
	
		request.setAttribute("bookList", bookList);
		RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	
	}
	
	
	/*
	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Books book = this.bookDAO.getBook(id);
		
		request.setAttribute("book", book);
		RequestDispatcher rd= request.getRequestDispatcher("admin-create.jsp");
		rd.forward(request, response);
	
	}
	
	
	private void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				
		
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String title = request.getParameter("title");
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		Books book = new Books(author, title, genre, price);
		
		int rowEffected = this.bookDAO.createBook(book);
		
		if(rowEffected > 0)
			showBookList(request, response);
		  

	}
	
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		int id=Integer.parseInt(request.getParameter("id"));
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String title = request.getParameter("title");
		double price = Double.parseDouble(request.getParameter("price"));
		
		Books book = new Books(id, author, title, genre, price);
		
		int rowEffected = this.bookDAO.updateBook(book);
		
		if(rowEffected > 0)
		  showBookList(request, response);

	}
	
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			int id=Integer.parseInt(request.getParameter("id"));
			
			int rowEffected = this.bookDAO.deleteBook(id);
			
			if(rowEffected > 0)
			  showBookList(request, response);
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

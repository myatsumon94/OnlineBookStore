package bookStore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
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
			
	/*	case "LOAD":
			loadBook(request, response);
			break;
		*/	
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
	}

	private void showBookList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Books> book_list = this.bookDAO.getBookList();
	
		request.setAttribute("book_list", book_list);
		RequestDispatcher rd= request.getRequestDispatcher("adminIndex.jsp");
		rd.forward(request, response);
	
	}
	
	/*
	private void loadBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Books bookList = this.bookDAO.getBook(id);
		
		request.setAttribute("book_list", bookList);
		RequestDispatcher rd= request.getRequestDispatcher("adminIndex.jsp");
		rd.forward(request, response);
	
	}
	*/
	
	private void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				
		PrintWriter out = response.getWriter();
		
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String title = request.getParameter("title");
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		Books bookList = new Books(author, title, genre, price);
		
		int rowEffected = this.bookDAO.createBook(bookList);
		
		if(rowEffected > 0)
			showBookList(request, response);
		  

	}
	
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();	
		
		int id=Integer.parseInt(request.getParameter("id"));
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String title = request.getParameter("title");
		double price = Double.parseDouble(request.getParameter("price"));
		
		Books bookList = new Books(id, author, title, genre, price);
		
		int rowEffected = this.bookDAO.updateBook(bookList);
		
		if(rowEffected > 0)
		  out.println("Successfully Updated New Book into Book Table");
		else
			 out.println("Fail to Update Book into Book Table");

	}
	
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			PrintWriter out = response.getWriter();	
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			int rowEffected = this.bookDAO.deleteBook(id);
			
			if(rowEffected > 0)
			  out.println("Successfully Deleted  ID = " + id +" from Book Table");
			else
				 out.println("Fail to Delete  ID = " + id + " from Book Table");
	
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

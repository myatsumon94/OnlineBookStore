package bookStore.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.sql.DataSource;

import bookStore.crypto.Hasher;
import bookStore.model.Admin;
import bookStore.model.AdminDAO;
import bookStore.model.User;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/bookStore")
	private DataSource dataSource;
	
	private AdminDAO adminDAO;
	
	@Override
	public void init() throws ServletException {
		
		adminDAO = new AdminDAO(dataSource);
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode="LOGIN_PAGE";
		}
		switch (mode) {
		case "LOGIN_PAGE":
			loginPage(request,response);
			break;
			
		case "SIGNIN":
			try {
				signin(request,response);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			loginPage(request,response);
			break;		

		}
	}

	private void signin(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ServletException {
		
		String email = request.getParameter("email");
		String originalPassword = request.getParameter("password");
		
		if (email == "" || originalPassword  == "") {
			System.out.println("Email or Password empty!");
			response.sendRedirect("adminlogin");
			return;
		}
		
		Admin admin = this.adminDAO.getAdminByEmail(email);
		
		if (admin == null) {
			System.out.println("Email not known");
			response.sendRedirect("adminlogin");
			return;
		}
		
		if (originalPassword.equals(admin.getPassword())) {
			
		
		        response.sendRedirect("adminbook");
				HttpSession session = request.getSession();
		        session.setAttribute("admin", admin);
  	    }else {
		boolean loginFail = true;
		request.setAttribute("loginFail", loginFail);
		RequestDispatcher rd = request.getRequestDispatcher("admin-signin.jsp");
		rd.forward(request, response);
		//return;
	}
	
	//    response.sendRedirect("adminlogin");
		
		
 // 		String hashed = Hasher.getHash(originalPassword);
////		
////		if (hashed.equals(admin.getPassword())) {
////			response.sendRedirect("adminbook");
////			
////			HttpSession session = request.getSession();
////			session.setAttribute("admin", admin);
////		}else {
////			boolean loginFail = true;
////			request.setAttribute("loginFail", loginFail);
////			RequestDispatcher rd = request.getRequestDispatcher("admin-signin.jsp");
////			rd.forward(request, response);
////			return;
////		}
////		
////		response.sendRedirect("adminlogin");
		
	
		
//		String email = request.getParameter("email");
//		String originalPassword = request.getParameter("password");
//		
//		boolean valid = this.adminDAO.isValidAdmin(email, originalPassword);
//		if(valid) {
//			response.sendRedirect("adminbook");
//			
//			Admin admin = this.adminDAO.getAdminByEmail(email);
//			HttpSession session = request.getSession();
//			session.setAttribute("admin", admin);
//		}else {
//			boolean loginFail = true;
//			request.setAttribute("loginFail", loginFail);
//			RequestDispatcher rd = request.getRequestDispatcher("admin-signin.jsp");
//			rd.forward(request, response);
//		}
		
	}


	private void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean loginFail = false;
		request.setAttribute("loginFail", loginFail);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-signin.jsp");
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

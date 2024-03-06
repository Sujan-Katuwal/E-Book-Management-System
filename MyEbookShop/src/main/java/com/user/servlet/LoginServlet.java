package com.user.servlet;

import java.io.IOException;

import com.DAO.UserDAO;
import com.DAO.UserDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	HttpSession session = request.getSession();
	 UserDAO userDao = new UserDAOImpl();
    if (userDao.isValidUser(email, password)) {
        session.setAttribute("succMsg", "Login Success");
        response.sendRedirect("index.jsp");
      
    }else if (email.equals("admin@gmail.com") && password.equals("admin")) {
		session.setAttribute("succMsg", "Welcome back boss!!!");
		response.sendRedirect("admin/index.jsp");
	}
    else {
    	session.setAttribute("faildMsg", "Login faild!! Check your email or password!!");
        response.sendRedirect("login.jsp");
    	
    }
	
	
			}

}

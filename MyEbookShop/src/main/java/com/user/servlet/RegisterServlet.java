package com.user.servlet;

import java.io.IOException;

import com.DAO.UserDAO;
import com.DAO.UserDAOImpl;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name=request.getParameter("fname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
//			String check = request.getParameter("check");
			
		   
		    
		    User user = new User();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setPhone(phone);

		    
		    HttpSession session = request.getSession();
		    
		    UserDAO userDao = new UserDAOImpl();
		    if (userDao.addUser(user)) {
		    	session.setAttribute("succMsg", "User Register Success !!!");
	    	response.sendRedirect("login.jsp");
	        } else {
	        	session.setAttribute("faildMsg", "Something Wrong on Server !!!");
	        	response.sendRedirect("register.jsp");
	        }
		  
					} catch (Exception e) {
						
						e.printStackTrace();
					}
	
		

	}

}
	


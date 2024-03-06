package com.user.servlet;

import java.io.File;


import java.io.IOException;

import com.DAO.AdminDAO;
import com.DAO.AdminDAOImpl;
import com.entity.AddBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;



/**
 * Servlet implementation class AddBookServlet
 */
@MultipartConfig
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public AddBookServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    try {
		String bName = request.getParameter("bname");
		String aName = request.getParameter("author");
		String price = request.getParameter("price");
		String bCategory = request.getParameter("categories");
		String bStatus = request.getParameter("status");
		Part part = request.getPart("bimg");
		String image = part.getSubmittedFileName();
		
		AddBook addBook = new AddBook();
		addBook.setBookName(bName);
		addBook.setAuthorName(aName);
		addBook.setPrice(price);
		addBook.setBookCategory(bCategory);
		addBook.setBookStatus(bStatus);
		addBook.setImage(image);
		
		HttpSession session = request.getSession();
		AdminDAO adminDao = new AdminDAOImpl();
		if(adminDao.addBook(addBook)) {
			String path = getServletContext().getRealPath("") +"book";
			File file = new File(path);
			part.write(path + File.separator + image);
			
			session.setAttribute("succMsg", "Book Added Success!!");
			response.sendRedirect("admin/add_book.jsp");
		}else {
			session.setAttribute("faildMsg", "Faild to add Book!!");
			response.sendRedirect("admin/add_book.jsp");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

}

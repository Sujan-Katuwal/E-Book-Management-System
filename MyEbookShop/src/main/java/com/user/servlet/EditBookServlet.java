package com.user.servlet;

import java.io.IOException;

import com.entity.AddBook;
import com.DAO.UserDAOImpl;
import com.entity.AddBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditBookServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String my_id = request.getParameter("Bid");
			
			String bName = request.getParameter("bname");
			String aName = request.getParameter("author");
			String price = request.getParameter("price");
			String bStatus = request.getParameter("status");
			
			AddBook b = new AddBook();
			b.setBookId(Integer.parseInt(my_id));
			b.setBookName(bName);
			b.setAuthorName(aName);
			b.setPrice(price);
			b.setBookStatus(bStatus);
			UserDAOImpl dao = new UserDAOImpl();
			boolean f=dao.updateEditBook(b);
			HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("succMsg", "Book Updated Successfully........");
				response.sendRedirect("admin/all_book.jsp");
			}else {
				session.setAttribute("faildMsg", "Something wrong on server........");
				response.sendRedirect("admin/all_book.jsp");
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

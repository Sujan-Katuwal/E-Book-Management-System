package com.user.servlet;

import java.io.IOException;

import com.DAO.UserDAOImpl;
import com.entity.AddBook;
import com.entity.Order;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));		
			User u = new User();
			UserDAOImpl dao = new UserDAOImpl();
			AddBook b=dao.getBookById(bid);
		
			Order order = new Order();
			order.setBid(bid);
			order.setUid(uid);
			order.setUserName(u.getName());
			order.setBookName(b.getBookName());
			order.setAuthorName(b.getAuthorName());
			order.setPrice(Double.parseDouble(b.getPrice()));
		
			boolean f = dao.payment(order);
			if(f) {
				System.out.println("Ädded to cart");
			}else {
				System.out.println("Faild to add");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

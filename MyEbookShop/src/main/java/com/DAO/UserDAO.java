package com.DAO;
import com.entity.User;

import java.util.List;

import com.entity.AddBook;
import com.entity.Cart;
import com.entity.Order;
public interface UserDAO {
	  boolean addUser(User user);
	
	boolean isValidUser(String email, String password);
    public List<AddBook> getNewBooks();
    public List<AddBook> getRecentBook();
    public List<AddBook> getOldBook();
    
    public List<AddBook> getAllRecentBook();
    public List<AddBook> getAllNewBook();
    public List<AddBook> getAllOldBook();
    
    public AddBook getBookById(int id);
    public boolean updateEditBook(AddBook b);
    public boolean payment(Order order);
 
}

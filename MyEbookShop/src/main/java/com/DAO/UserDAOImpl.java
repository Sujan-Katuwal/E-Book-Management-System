package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.AddBook;
import com.entity.Cart;
import com.entity.Order;
import com.entity.User;

public class UserDAOImpl implements UserDAO {


    public boolean addUser(User user) {
        String query = "INSERT INTO user(name, email, password, phone) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


	@Override
	public boolean isValidUser(String email, String password) {
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
	    	 try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	           ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	}


	@Override
	public List<AddBook> getNewBooks() {
		List list = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=?";
//		order by bookId DESC
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "New");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			int i = 1;
			while(resultSet.next() && i<=4) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				list.add(b);
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}


	@Override
	public List<AddBook> getRecentBook() {
		List lists = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=? order by bookId DESC";
//		order by bookId DESC
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "New");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			int i = 1;
			while(resultSet.next() && i<=4) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				lists.add(b);
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lists;
		
	}


	@Override
	public List<AddBook> getOldBook() {
		List old_list = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=?";
//		order by bookId DESC
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "Old");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			int i = 1;
			while(resultSet.next() && i<=4) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				old_list.add(b);
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return old_list;
	}


	@Override
	public List<AddBook> getAllRecentBook() {
		List lists = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=? order by bookId DESC";
//		order by bookId DESC
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "New");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				lists.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public List<AddBook> getAllNewBook() {
		List lists = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=? ";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "New");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				lists.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;

	}


	@Override
	public List<AddBook> getAllOldBook() {
		List lists = new ArrayList<AddBook>();
		String query = "select * from books where book_categorie=? and book_status=? ";
//		order by bookId DESC
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, "Old");
			prepareStatement.setString(2, "Active");
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				lists.add(b);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public AddBook getBookById(int id) {

		AddBook b = null;
		String query = "select * from books where bookId=?";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				 b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public boolean payment(Order order) {
		String query = "insert into order(id,bid,uid,user_name,book_name,author_name,price) values(?,?,?,?,?,?,?)";
		
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, order.getId());
			prepareStatement.setInt(2, order.getBid());
			prepareStatement.setInt(3, order.getUid());
			prepareStatement.setString(4, order.getUserName());
			prepareStatement.setString(5, order.getBookName());
			prepareStatement.setString(6, order.getAuthorName());
			prepareStatement.setDouble(7, order.getPrice());
			int rowsAffected=prepareStatement.executeUpdate();
			if(rowsAffected > 0) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean updateEditBook(AddBook b) {
	String query = "update books set book_name=?, author=?, price=?, book_status=? where bookId=?";
	try {
		Connection connection = DBConnect.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, b.getBookName());	
		prepareStatement.setString(2, b.getAuthorName());
		prepareStatement.setString(3, b.getPrice());
		prepareStatement.setString(4, b.getBookStatus());
		prepareStatement.setInt(5, b.getBookId());
		
		int rowsAffected=prepareStatement.executeUpdate();
		if(rowsAffected > 0) {
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return false;
	}


	
}

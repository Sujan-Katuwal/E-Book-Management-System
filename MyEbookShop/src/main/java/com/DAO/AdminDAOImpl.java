package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.AddBook;

public  class AdminDAOImpl implements AdminDAO {

	public boolean addBook(AddBook addBook) {
		String query = "insert into books(book_name, author, price, book_categorie, book_status, image) values(?, ?, ?, ?, ?, ?)";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, addBook.getBookName());
			preparedStatement.setString(2, addBook.getAuthorName());
			preparedStatement.setString(3, addBook.getPrice());
			preparedStatement.setString(4, addBook.getBookCategory());
			preparedStatement.setString(5, addBook.getBookStatus());
			preparedStatement.setString(6, addBook.getImage());

			int rowAffected = preparedStatement.executeUpdate();
			return rowAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<AddBook>getAllBook() {
		List list = new ArrayList<AddBook>();
		
		String query = "SELECT * FROM books";
		
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
		
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				AddBook b = new AddBook();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthorName(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBookCategory(resultSet.getString(5));
				b.setBookStatus(resultSet.getString(6));
				b.setImage(resultSet.getString(7));
				list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return list;
	}

}

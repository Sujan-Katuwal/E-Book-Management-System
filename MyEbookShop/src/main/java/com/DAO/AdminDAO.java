package com.DAO;

import java.util.List;

import com.entity.AddBook;

public interface AdminDAO {
	boolean addBook(AddBook addBook);
	
	public List<AddBook>getAllBook();

}

package br.com.allianz.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.allianz.model.Book;

public class BooksDao extends Dao {

	/**
	 * Includes a new book
	 */
	public void includeBook(Book book) throws Exception {
		try {
			openConnection();
			String sql = "INSERT INTO LIVROS (TITULO,AUTOR,DATAPUB,PRECO) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setDate(3, new Date(book.getPublicationDate().getTime()));
			stmt.setDouble(4, book.getPrice());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection();
		}
	}

	public List<Book> listBooks() throws Exception {
		List<Book> books = new ArrayList<>();
		try {
			openConnection();
			stmt = cn.prepareStatement("SELECT * FROM LIVROS");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("TITULO"));
				book.setAuthor(rs.getString("AUTOR"));
				book.setPublicationDate(rs.getDate("DATAPUB"));
				book.setPrice(rs.getDouble("PRECO"));
				books.add(book);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection();
		}

		return books;
	}
}
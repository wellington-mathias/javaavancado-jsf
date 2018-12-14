package br.com.allianz.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.allianz.dao.BooksDao;
import br.com.allianz.model.Book;

@ManagedBean(name = "beanBooks")
@RequestScoped
public class BooksBean {
	private Book book;

	public BooksBean() {
		if (book == null) {
			book = new Book();
		}
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Action method to include a new book
	 */
	public String includeBook() {
		FacesMessage message = new FacesMessage();
		try {
			new BooksDao().includeBook(book);

			message.setSummary("OK");
			message.setDetail("Livro incluído");
			message.setSeverity(FacesMessage.SEVERITY_INFO);

			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();

			message.setSummary("OK");
			message.setDetail(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			return "erro";
		}

	}

	public List<Book> getBooksList() throws Exception {
		return new BooksDao().listBooks();
	}
}
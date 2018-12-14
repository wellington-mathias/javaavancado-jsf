package br.com.allianz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private Date publicationDate;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(publicationDate);
			this.setPublicationDate(date);
		} catch (Exception e) {
			this.setPublicationDate(new Date());
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
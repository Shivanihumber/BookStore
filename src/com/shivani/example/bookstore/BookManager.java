package com.shivani.example.bookstore;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class BookManager {
    public static int ID_COUNT = 0;
	private List<Book> books;
	
	public BookManager() {
	    this.books = new ArrayList<>();
	    books.add(new Book(++ID_COUNT, "Crime and Punishment", "Fedor Dostoevsky", 57.5f));
	}
	
	public void insertBook(Book book) {
		books.add(book);
	}
	
	public List<Book> listAllBooks() {
	    return books;
	}
	
	public void deleteBook(int id)  {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                break;
            }
        }
	}
	
	public void updateBook(Book book) {
        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
            }
        }
	}
	
	public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
	}
}

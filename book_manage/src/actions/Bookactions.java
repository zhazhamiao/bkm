package actions;

import book.Book;

//用户对图书操作
public interface Bookactions {
	public  boolean rentbook(Book book);
	public boolean returnbook(Book book);
}

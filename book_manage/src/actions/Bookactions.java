package actions;

import book.Book;

//�û���ͼ�����
public interface Bookactions {
	public  boolean rentbook(Book book);
	public boolean returnbook(Book book);
}

package book;

public class Book {
	
	private int num;
	private String name;
	private String author;
	private String press;
	private String type;
	private int exist = 0;
	private String rent = "";
	
	@SuppressWarnings("unused")
	private Book() {
	}
	public Book(int num,String name,String author,String press,String type) {
		this.num = num;
		this.name = name;
		this.author = author;
		this.press = press;
		this.type = type;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	public String getPress() {
		return press;
	}
	public String getRent() {
		return rent;
	}
	public String getType() {
		return type;
	}
	public int getExist() {
		return exist;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public void setType(String type) {
		this.type = type;
	}
}
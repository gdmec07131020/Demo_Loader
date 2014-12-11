package cn.edu.gdmec.s07131020.demo_loader;

public class Book {
  private String _id;
  private String name;
  private float price;
  private String publisher;
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public Book(String _id, String name, float price, String publisher) {
	super();
	this._id = _id;
	this.name = name;
	this.price = price;
	this.publisher = publisher;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Book [_id=" + _id + ", name=" + name + ", price=" + price
			+ ", publisher=" + publisher + "]";
}
  
  
}

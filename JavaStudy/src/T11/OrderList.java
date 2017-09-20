package T11;

public class OrderList {

	private String id;
	private String name;
	private String price;
	private String where;
	public OrderList(String id,String name,String price,String where){
		this.id=id;
		this.name=name;
		this.price=price;
		this.where=where;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
}

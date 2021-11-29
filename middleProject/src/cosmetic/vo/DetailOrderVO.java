package cosmetic.vo;

public class DetailOrderVO {
	private String order_id;
	private String prod_id;
	private String del_option;
	private int del_quanity;
	private int del_price;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getDel_option() {
		return del_option;
	}
	public void setDel_option(String del_option) {
		this.del_option = del_option;
	}
	public int getDel_quanity() {
		return del_quanity;
	}
	public void setDel_quanity(int del_quanity) {
		this.del_quanity = del_quanity;
	}
	public int getDel_price() {
		return del_price;
	}
	public void setDel_price(int del_price) {
		this.del_price = del_price;
	}
	
	
}

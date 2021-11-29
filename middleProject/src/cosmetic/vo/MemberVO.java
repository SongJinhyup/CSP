package cosmetic.vo;

public class MemberVO {
	private String mem_id;
	private String mem_pass;
	private String mem_type;
	private String mem_name;
	private String mem_email;
	private String mem_tel;
	private String mem_birth;
	private String mem_cupon;
	private String mem_blocation;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_type() {
		return mem_type;
	}
	public void setMem_type(String mem_type) {
		this.mem_type = mem_type;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_cupon() {
		return mem_cupon;
	}
	public void setMem_cupon(String mem_cupon) {
		this.mem_cupon = mem_cupon;
	}
	public String getMem_blocation() {
		return mem_blocation;
	}
	public void setMem_blocation(String mem_blocation) {
		this.mem_blocation = mem_blocation;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_type=" + mem_type + ", mem_name="
				+ mem_name + ", mem_email=" + mem_email + ", mem_tel=" + mem_tel + ", mem_birth=" + mem_birth
				+ ", mem_cupon=" + mem_cupon + ", mem_blocation=" + mem_blocation + "]";
	}

	
	
	
	
}

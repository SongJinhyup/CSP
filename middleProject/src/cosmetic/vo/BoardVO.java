package cosmetic.vo;

public class BoardVO {
	private String board_id;	//게시글번호
	private String mem_id;		//사용자 이름
	private String board_index;	//게시판 종류
	private String board_title;	//제목
	private String board_date;	//작성일
	private String board_content;	//내용
	private String prod_id;			//제품아이디
	private String prod_name;		//제품명
	private String board_secrete;	//비공개여부
	private String board_img; 	//리뷰용 이미지
	
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBoard_index() {
		return board_index;
	}
	public void setBoard_index(String board_index) {
		this.board_index = board_index;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getBoard_secrete() {
		return board_secrete;
	}
	public void setBoard_secrete(String board_secrete) {
		this.board_secrete = board_secrete;
	}
	public String getBoard_img() {
		return board_img;
	}
	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

		
}

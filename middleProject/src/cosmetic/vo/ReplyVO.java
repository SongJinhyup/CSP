package cosmetic.vo;

public class ReplyVO {
	private String reply_id;
	private String board_id;
	private String mem_id;
	private String reply_parent;
	private String reply_content;
	private String reply_secret;
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
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
	public String getReply_parent() {
		return reply_parent;
	}
	public void setReply_parent(String reply_parent) {
		this.reply_parent = reply_parent;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_secret() {
		return reply_secret;
	}
	public void setReply_secret(String reply_secret) {
		this.reply_secret = reply_secret;
	}
	
	
}

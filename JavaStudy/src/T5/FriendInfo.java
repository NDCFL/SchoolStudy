package T5;

public class FriendInfo {

	private int qqCode;
	private String nickName;
	private String headimg;
	private String remark;
	public FriendInfo() {
	
	}
	public FriendInfo(int qqCode,String nickName,String headimg,String remark) {
		this.qqCode = qqCode;
		this.nickName = nickName;
		this.headimg = headimg;
		this.remark = remark;
	}
	public int getQqCode() {
		return qqCode;
	}
	public void setQqCode(int qqCode) {
		this.qqCode = qqCode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

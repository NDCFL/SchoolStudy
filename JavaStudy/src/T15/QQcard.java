package T15;
                                                 
import java.io.Serializable;

public class QQcard implements Serializable{

	private int id;
	private String name;
	private String QQ;
	private String password;
	private String sex;
	private String email;
	private String tel;
	private String qiangming;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qq) {
		QQ = qq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQiangming() {
		return qiangming;
	}
	public void setQiangming(String qiangming) {
		this.qiangming = qiangming;
	}
	
}

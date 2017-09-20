package T6;

public class Entrybean {

	private String name;
	private String pass1;
	private String pass2;
	private int age1;
	private String sex;
	private boolean gread;
	private String hobit[];
	private String province;
	private String city;
	private String county;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public int getAge1() {
		return age1;
	}
	public void setAge1(int age1) {
		this.age1 = age1;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobit() {
		return hobit;
	}
	public String getHobit(int index){
		return hobit[index];
	}
	public void setHobit(int index,String ho){
		hobit[index]=ho;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public boolean isGread() {
		return gread;
	}
	public void setGread(boolean gread) {
		this.gread = gread;
	}
}

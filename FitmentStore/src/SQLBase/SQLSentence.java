package SQLBase;

import java.util.List;

import SQLBean.ProvinceBean;
import SQLBean.UserBean;

public interface SQLSentence {

	//省份城市的新增删除和修改
	public abstract List<ProvinceBean> provincelist();
	public abstract List<ProvinceBean> provincelist(int pagesize,int startpage);
	public abstract void delprovince (int provinceid);
	public abstract void addprovince(ProvinceBean provincebean);
	public abstract void updataeprovince(ProvinceBean provincebean);
	public abstract int sumbar(String sql);
	//用户的注册操作
	//省份城市的新增删除和修改
	public abstract List<UserBean> userlist();
	public abstract List<UserBean> userlist(int pagesize,int startpage);
	public abstract void deluser (int userid);
	public abstract void adduser(UserBean userbean);
	public abstract void updateuserbean(UserBean userbean);
	public abstract int finduser(String mobilephone);
	public abstract UserBean logincheck(String name);
}

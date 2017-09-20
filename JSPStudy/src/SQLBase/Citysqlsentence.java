package SQLBase;

import java.util.List;

import SQLBean.Citybean;
import SQLBean.Privacebean;

public interface Citysqlsentence {
	
	//查询语句
	public abstract List<Citybean> citylist();
	//删除语句
	public abstract void citydel(int cityid);
	//更新语句
	public abstract void cityupdate(Citybean citybean);
	//添加语句
	public abstract void cityadd(Citybean citybean);
	//查询城市的函数
	public List<Privacebean> privacelist() ;
	public abstract Citybean findcity(String cityid);
	public abstract int pagebarsum ();
	public abstract List<Citybean> citylist(int pagebarsize,int startlocal);
	
}

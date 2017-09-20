package SQLBase;

import java.util.List;

import SQLBean.Privacebean;

public interface Privacesqlsentence {

	//查询语句
	public abstract List<Privacebean> privacelist();
	//删除语句
	public abstract void privacedel(int privaceid);
	//更新语句
	public abstract void privaceupdate(Privacebean privacebean);
	//添加语句
	public abstract void privaceadd(Privacebean citybean);
	public abstract int sumbar();
	public abstract List<Privacebean> privacelist(int pagesize,int startpage);
	public abstract List<Privacebean> cityalllist(String privacename);
}

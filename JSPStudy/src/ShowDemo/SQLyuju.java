package ShowDemo;

import java.util.List;

public interface SQLyuju {

	public abstract List<VoteBean> votelist (int pagesize,int startpage);
	public abstract int barsum();
}

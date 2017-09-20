package edu.ht.service;


import java.util.List;
import java.util.Vector;

import edu.ht.bean.Qquser;

public interface QquserService {
	//添加用户
	public boolean addUSer(Qquser quser);
	
	//判断QQ号是否存在
	public boolean selUser(String qqnum);
	
	
	//验证登录 并返回用户对象
	public Qquser chkUser(Qquser quser);
	
	//更改用户在线状态
	public boolean updUserState(Qquser quser);
	
	//保存登录历史
	
	public boolean saveHistory(Qquser quser);
	
	//查询登录历史
	public List selHistory();
	
	//根据分组查询好友 返回好友列表
	public Vector<Qquser> selFriendByGroup(String qqnum,String groupname);
	
	//查找好友
	public Vector selectFriend(Qquser quser);
	
	//根据QQ号查询用户对象
	public Qquser selUserByQQnum(String qqnum);
	
	//添加好友的方法
	public boolean addFriend(Qquser myuser,Qquser fruser,String groupname);
	
	//检查好友吃否存在
	public boolean selFF(String mynum,String frnum);
	
	//删除好友
	public boolean delFF(Qquser myqq,Qquser frqq);
	
	//移动到分组
	public boolean moveFF(Qquser myqq,Qquser frqq,String groupname);
	
	//修改个人资料
	public boolean updInfo(Qquser quser);
}

package QQSQL;

public interface QQminlin {

	//上线通知（登录)
	public static final int CMD_ONLINE	=0;
	//离线
	public static final int CMD_OFFLINE	=1;
	//离开
	public static final int CMD_LEVEL	=2;
	//忙碌
	public static final int CMD_BUYS	=3;
	//发送信息
	public static final int CMD_SEND	=4;
	//发送文件
	public static final int CMD_FILE	=5;
	//抖动
	public static final int CMD_SHAKE	=6;
	//添加好友
	public static final int CMD_ADDFRI	=7;
	//同意添加好友
	public static final int CMD_ARGEE	=8;
	//拒绝添加好友
	public static final int CMD_REFUSE	=9;
	//更改状态
	public static final int CMD_CHANGESTATE	=10;
	//删除好友
	public static final int CMD_DELETE=11;
	//视频聊天
	public static final int CMD_SHIPING=12;
	//在线状态
	public static final String[] STATUS={"在线","离线","忙碌","隐身"};
	//分组名称
	public static final String[] GROUPNAME={
		"损友","同学","死党","朋友","黑名单"
	};
}

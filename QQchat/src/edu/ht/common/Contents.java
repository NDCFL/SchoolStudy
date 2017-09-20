package edu.ht.common;

public class Contents {
	public static final int STATE_DOWNLINE = 0;// 离线
	public static final int STATE_ONLINE = 1;// 在线
	public static final int STATE_HIDE = 2;// 隐身
	public static final int STATE_BUSY = 3;// 忙碌
	public static final int STATE_LEAVE = 4;// 离开
	
	public static final String GROUP_FRIEND="好友";
	public static final String GROUP_FAMILY="家人";
	public static final String GROUP_CLASSMATE="同学";
	public static final String GROUP_BLACK="黑名单";
	
	
	//命令
	public static final int CMD_INLINE=1000;//上线通知
	public static final int CMD_OFFLINE=1001;//下线通知
	public static final int CMD_BUSY=1002;//忙碌通知
	public static final int CMD_LEAVE=1003;//离开通知
	public static final int CMD_HIDE=1009;//隐身通知
	
	public static final int CMD_CHAT=1004;//聊天通知
	public static final int CMD_SHKAE=1005;//抖动通知
	public static final int CMD_ADDFRIEND=1006;//添加好友通知
	public static final int CMD_DELFRIEND=1007;//删除好友通知
	public static final int CMD_SENDFILE=1008;//发送文件通知
	
	public static final int CMD_AGREE=1010;//同意了添加请求
	public static final int CMD_NOADD=1011;//拒绝了请求
	
	public static final int CMD_FILEAGREE=1012;//同意接收文件
	public static final int CMD_FILENO=1013;//拒绝接收文件
	
	public static final String S_QIAOMEN="Global.wav";//敲门
	public static final String S_KESHOU="system.wav";//咳嗽
	
	
}

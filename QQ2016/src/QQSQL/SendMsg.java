package QQSQL;

import java.io.Serializable;

import javax.swing.text.StyledDocument;

import QQbean.QQidtable;

/*
 * 发送数据包
 * */
public class SendMsg implements Serializable{

	//命令字
	public int cmd;
	//发送人信息
	public QQidtable idtable;
	//接收人信息
	public QQidtable friendtable;
	//发送的内容
	public StyledDocument doc;
	//发送文件内容在64K以下
	public byte b[];
	public String fileName;
	public String del;
}

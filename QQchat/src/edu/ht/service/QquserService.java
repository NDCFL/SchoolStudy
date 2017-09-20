package edu.ht.service;


import java.util.List;
import java.util.Vector;

import edu.ht.bean.Qquser;

public interface QquserService {
	//�����û�
	public boolean addUSer(Qquser quser);
	
	//�ж�QQ���Ƿ����
	public boolean selUser(String qqnum);
	
	
	//��֤��¼ �������û�����
	public Qquser chkUser(Qquser quser);
	
	//�����û�����״̬
	public boolean updUserState(Qquser quser);
	
	//�����¼��ʷ
	
	public boolean saveHistory(Qquser quser);
	
	//��ѯ��¼��ʷ
	public List selHistory();
	
	//���ݷ����ѯ���� ���غ����б�
	public Vector<Qquser> selFriendByGroup(String qqnum,String groupname);
	
	//���Һ���
	public Vector selectFriend(Qquser quser);
	
	//����QQ�Ų�ѯ�û�����
	public Qquser selUserByQQnum(String qqnum);
	
	//���Ӻ��ѵķ���
	public boolean addFriend(Qquser myuser,Qquser fruser,String groupname);
	
	//�����ѳԷ����
	public boolean selFF(String mynum,String frnum);
	
	//ɾ������
	public boolean delFF(Qquser myqq,Qquser frqq);
	
	//�ƶ�������
	public boolean moveFF(Qquser myqq,Qquser frqq,String groupname);
	
	//�޸ĸ�������
	public boolean updInfo(Qquser quser);
}
package T7;

import java.io.Serializable;

public class User implements Serializable{

	private String password;  
	private String loginName;  
	public String getLoginName(){   
	return loginName;  
	}  
	public String getPassword(){  
	return password; 
	}  
	public void setLoginName(String loginName){
	  this.loginName=loginName; 
	}  
	public void setPassword(String password){
	  this.password=password; 
	} 
}

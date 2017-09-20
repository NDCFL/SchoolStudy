function $C(id,name){
	var val=document.getElementById(id).value;
	if(val==""){
		alert(name+"不能为空!");
		document.getElementById(id).onfocus();
		val="";
		return false;
	}else if(isNaN(val)){
		alert(name+"含有非法字符！");
		return false;
	}else{
		return true;
	
	}
}
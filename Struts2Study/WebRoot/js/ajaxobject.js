var hr=null;
function create(){
	try{
		hr = new XMLHttpRequest();
	}catch(e){
		try{
			hr = new ActiveXObject("Msxml2.HTTPXML");
		}catch(e){
			try{
				hr = new ActiveXObject("Microsoft.HTTPXML");
			}catch(e){
				alert("create fail");
			}
		}    		
	}
}
function sendRequest(method,url,paramValue,ascy){
	create();
	if (!hr) return false;
	hr.onreadystatechange = displayResponse;
	hr.open(method,url+"?"+paramValue,false);
	if(method=="get" || method=="GET"){
		hr.send(null);
	}else if(method=="post" || method=="POST"){
		hr.send(paramValue);
	}
}
  	
var httpRequest=null;

function createHttpRequest(){
	if(window.ActiveXObject){	//IE
		return new ActiveXObject("Msxml2.XMLHTTP");		//IE 8이상
		
	}else if(window.XMLHttpRequest){	//크롬, FF
		return new XMLHttpRequest();
	}
}

function sendMessage(method,url,param,callback){
	//연결
	httpRequest=createHttpRequest();
	
	var httpParam=param;
	alert(param);
	
	var httpUrl=url;
	
	if(method=='GET' || method==null){
		httpUrl=httpUrl +"?"+ httpParam;
	}
	alert(httpUrl);
	
	httpRequest.open(method,httpUrl,true);
	/*
	 * true : 비동기적
	 * false : 동기적
	 */
	
	httpRequest.onreadystatechange=callback;
	httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httpRequest.send(method==null||method=="GET"?null:param);
	
}


























































var xmlHttpRequest = window.ActiveXObject ? new ActiveXObject("Microsoft.XMLHTTP") : new XMLHttpRequest();
if(type==1){
	xmlHttpRequest.open("POST",encodeURI("/bjcc/writeBehavior.action?articleID="+articleID+"&articleName="+articleName+"&channelID="+channelID+"&channelName="+channelName+"&type="+type),true);
	xmlHttpRequest.send(null);
}else{
	xmlHttpRequest.open("POST",encodeURI("/bjcc/writeBehavior.action?articleID="+articleID+"&type="+type),true);
	xmlHttpRequest.send(null);

	window.onbeforeunload=function onclose(){
		var isIE=(document.all && window.ActiveXObject && !window.opera) ? true : false;
		//evt = evt ? evt : (window.event ? window.event : null);

		//var xmlHttpRequest;
		//xmlHttpRequest=window.ActiveXObject ? new ActiveXObject("Microsoft.XMLHTTP") : new XMLHttpRequest();

		if(isIE){
			var n = window.event.screenX - window.screenLeft;
			var b = n > document.documentElement.scrollWidth-20;
			var s = window.event.clientY-document.body.clientHeight;
			if(b && window.event.clientY < 0 || window.event.altKey){
				  xmlHttpRequest.open("POST",encodeURI("/bjcc/userBehavior.action?articleID="+articleID+"&articleName="+articleName+"&channelID="+channelID+"&channelName="+channelName+"&type="+type),true);
				  xmlHttpRequest.send(null);
			}else if((event.clientY > document.body.clientHeight && event.keyCode != 116) || event.altKey){
				  xmlHttpRequest.open("POST",encodeURI("/bjcc/userBehavior.action?articleID="+articleID+"&articleName="+articleName+"&channelID="+channelID+"&channelName="+channelName+"&type="+type),true);
				  xmlHttpRequest.send(null);
			}
		}
	}
}

// JavaScript Document


function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
 for(i=0;i<tli.length;i++){	 
  tli[i].className=i==n?"hover":"";  
  mli[i].style.display=i==n?"block":"none";  
 }
 
}
setTab(1,0);




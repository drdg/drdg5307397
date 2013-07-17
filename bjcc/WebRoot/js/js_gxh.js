// JavaScript Document


function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("a");
 var mli=document.getElementById("main"+m).getElementsByTagName("table"); 
 for(i=0;i<tli.length;i++){	 
  tli[i].className=i==n?"hover":"";  
  mli[i].style.display=i==n?"block":"none";  
 }
 
}
setTab(1,0);

function setTab1(m,n){
 var tli=document.getElementById("menu_a"+m).getElementsByTagName("a");
 var mli=document.getElementById("main_a"+m).getElementsByTagName("ul"); 
 for(i=0;i<tli.length;i++){	 
  tli[i].className=i==n?"hover":"";  
  mli[i].style.display=i==n?"block":"none";  
 }
 
}
setTab1(1,0);





 //Êó±ê»¬¹ýµ¯³ö²ã
function zttc(obj, sType) { 
var oDiv = document.getElementById(obj); 
if (sType == 'show') { oDiv.style.display = 'block';} 
if (sType == 'hide') { oDiv.style.display = 'none';} 

} 








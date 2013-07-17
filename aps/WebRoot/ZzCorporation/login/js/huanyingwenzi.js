// JavaScript Document

//luxiaoqing
Phrase="欢迎登录爱配送后台系统"
Balises=""
Taille=40;
Midx=100;
Decal=0.5;
Nb=Phrase.length;
y=-10000;
for (x=0;x<Nb;x++){
  Balises=Balises + '<DIV Id=L' + x + ' STYLE="width:3;font-family: Courier New;font-weight:bold;position:absolute;top:40;left:50;z-index:0">' + Phrase.charAt(x) + '</DIV>'
}
document.write (Balises);
Time=window.setInterval("Alors()",50);
Alpha=5;
I_Alpha=0.05;

function Alors(){
	Alpha=Alpha-I_Alpha;
	for (x=0;x<Nb;x++){
		Alpha1=Alpha+Decal*x;
		Cosine=Math.cos(Alpha1);
		Ob=document.all("L"+x);
		Ob.style.posLeft=Midx+100*Math.sin(Alpha1)+50;
		Ob.style.zIndex=20*Cosine;
		Ob.style.fontSize=Taille+25*Cosine;
		Ob.style.color="rgb("+ (27+Cosine*80+50) + ","+ (127+Cosine*80+50) + ",0)";
	}
}



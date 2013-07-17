// JavaScript Document
 var setVal;  
    var bool = false;    
    var scrollFunc=function(e){ 
        var direct=0; 
        e=e || window.event; 
        var ew = e.wheelDelta
        if(ew && bool){
			//ew > 0ио╧Ж
            if(ew > 0){
                var num1 = setVal.value;
                if(num1 > 0 ){
                    num1 = eval(1+parseInt(num1));
                }else{
                    num1 = 1;
                }
            }else{
                var num1 = setVal.value;
                if(num1 >= 1){
                    num1 = eval(parseInt(num1)-1);
                }else if(num1 == 0){
                    num1 = 0;
                }  
            }
            
            setVal.value = num1;
        }
       
    } 

    window.onmousewheel=document.onmousewheel=scrollFunc;
    
    function ufocus(eve){
        bool = true;
        setVal = eve;
    }
    
    function ublur(){
        bool = false;
        setVal = null;
    }
	
	function sumSub(){
		var number = "";
		if((number = $("#gzz").val()) == 0){
			number = 1;
		}
		if(parseInt(number) > parseInt(document.getElementById("pageS").innerHTML)){
			number = document.getElementById("pageS").innerHTML;
		}
		var Ourl = document.getElementById("agzz").href+number;
		document.getElementById("agzz").href = Ourl;	

	}
	function sumClear(){
        document.getElementById("gzz").value = 1;
    }
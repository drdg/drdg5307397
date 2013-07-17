// JavaScript Document
	/*根据获得焦点的时候给setVal给值*/
    var setVal;  
    var bool = false;    
    var scrollFunc=function(e){ 
        var direct=0; 
        e=e || window.event; 
        var ew = e.wheelDelta
        if(ew && bool){
			//ew > 0上滚
            if(ew > 0){
                var num1 = setVal.value;
                if(num1 > 0){
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
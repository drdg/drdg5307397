// JavaScript Document
	$(function(){
			   
		var regex = new RegExp("^[0-9]{1,5}$");

		/*对输入的首公斤验证*/
		$("#drfkg").focus(function(){
				
			$(".eisok").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;1-5位有效数字</span>");
			}
			
		}).blur(function(){
			
			$(".eisok").empty();
				
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;×</span>");
			}
		});
		/*对输入的次公斤验证*/	
		$("#drokg").focus(function(){
				
			$(".eisok1").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;1-5位有效数字</span>");
			}
			
		}).blur(function(){
			
			$(".eisok1").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;×</span>");
			}
		});
	});
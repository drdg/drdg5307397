// JavaScript Document
	var bool = false;
	$(function(){
			   
		var regex = new RegExp("^[0-9]{1,8}&");

		/*对输入的编号验证*/
		$("#auno").focus(function(){
				
				$(".eisok").empty();
				
				if(regex.test($(this).val())){
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;长度八位有效数字</span>");
					bool = false;
				}
			
		}).blur(function(){
			
			$(".eisok").empty();
			
			if(regex.test($(this).val())){
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}
			
		});   
			
			
		var regexdesc = new RegExp("^[\u4E00-\u9FA5]{2,10}$");
		/*对用户名*/
		$("#audesc").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexdesc.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;2-10个汉字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok2").empty();
				
				if(regexdesc.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});	
	});
	
	function pdsub(){
		return bool;
	}
	
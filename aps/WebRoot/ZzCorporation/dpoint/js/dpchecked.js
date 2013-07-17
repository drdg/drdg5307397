// JavaScript Document	
	var bool = false;
	$(function(){
		var regexName = new RegExp("^[\u4E00-\u9FA5]{3,10}$");
		/*对用户名*/
		$("#dpname").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;3-10个汉字名</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok2").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});	
		
		var regexAddress = new RegExp("^[\u4E00-\u9FA5]{3,20}$");
		/*对地址匹配*/
		$("#dpaddress").focus(function(){
			
			$(".eisok3").empty();
			
			if(regexAddress.test($(this).val())){
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;3-20个汉字名</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok3").empty();
				
				if(regexAddress.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});		
		
		var regexTel = new RegExp("^[1]{1}[0-9]{10}$");
		/*对手机号进行匹配*/
		$("#dptel").focus(function(){
								   
			$(".eisok1").empty();
			
			if(regexTel.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;11位数字手机号</span>");
				bool = false;
			}
					   
		}).blur(function(){
				
				$(".eisok1").empty();
				
				if(regexTel.test($(this).val())){
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
			
		});
		
		var regexEmail = new RegExp("^[a-zA-Z0-9]+@[a-zA-Z]{2,5}\\56{1}(com|cn)$");
		/*对email的匹配*/
		$("#dpemail").focus(function(){
			$(".eisok4").empty();
			
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;输入邮箱号</span>");
				bool = false;
			}
		}).blur(function(){
			
			$(".eisok4").empty();
				
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;×</span>");
				bool = false;
			}
		});
	});
	
	
	function doLogin(){
		alert(bool);
		return bool;
	}
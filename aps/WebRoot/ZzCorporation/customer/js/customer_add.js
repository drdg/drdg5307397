// JavaScript Document

	$(function(){
		
		var regexName1 = new RegExp("^[a-zA-Z]{2,10}$");
		/*对昵称*/
		$("#cnickname").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName1.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;2-10个英文字母</span>");
			}

		}).blur(function(){
				
				$(".eisok2").empty();
				
				if(regexName1.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;×</span>");
				}
		
		});
		
		var regexName = new RegExp("^[\u4E00-\u9FA5]{2,3}$");
		/*对昵称*/
		$("#cname").focus(function(){
			
			$(".eisok1").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;2-3个汉字</span>");
			}

		}).blur(function(){
				
				$(".eisok1").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
				}else{
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;×</span>");
				}
		
		});
		
		
		var regexAge = new RegExp("^[1]{1}[0-9]{10}$");
		/*对手机号进行匹配*/
		$("#ctel").focus(function(){
								   
			$(".eisok3").empty();
			
			if(regexAge.test($(this).val())){
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;11位数字手机号</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok3").empty();
				
				if(regexAge.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;×</span>");
				}
			
		});
		
		var regexEmail = new RegExp("^[a-zA-Z0-9]+@[a-zA-Z]{2,5}\\56{1}(com|cn)$");
		/*对email的匹配*/
		$("#cemail").focus(function(){
			$(".eisok4").empty();
			
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;输入邮箱号</span>");
			}
		}).blur(function(){
			
			$(".eisok4").empty();
				
			if(regexEmail.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;×</span>");
			}
		});
		
		/*密码验证**/
		
		var regexPwd = new RegExp("^[0-9A-Za-z]{6,15}$");
		$("#cpwd").focus(function(){
								   
			$(".eisok5").empty();
			
			if(regexPwd.test($(this).val())){
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;6-15个数字英文密码</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok5").empty();
				
				if(regexPwd.test($(this).val())){
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
				}else{
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;×</span>");
				}
			
		});
		/*密码确认*/
		$("#cpwd2").focus(function(){
								   
			$(".eisok7").empty();
			
			if(regexPwd.test($(this).val())){
				$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;√</span>");
			}else{
				$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;6-15个数字英文密码</span>");
			}
					   
		}).blur(function(){
				
				$(".eisok7").empty();
				
				if(regexPwd.test($(this).val()) && $(this).val() == $("#cpwd").val()){
					$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;√</span>");
				}else{
					$(this).after("<span class='eisok7' style='color:red; width:15px;'>&nbsp;×密码不统一</span>");
				}
			
		});
		
	});
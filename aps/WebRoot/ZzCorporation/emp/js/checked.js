// JavaScript Document
	
	var bool = false;
	$(function(){	
		var regex = new RegExp("^[0-9]{8}");

		var regexName = new RegExp("^[\u4E00-\u9FA5]{2,3}$");
		/*对用户名*/
		$(".ename").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;2-3个汉字名</span>");
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
		
		/*对年龄根据生日自动生成*/
		$(".eage").click(function(){
			var d = new Date();	
			$(".eage").val(parseInt(d.getFullYear()) - $(".ebir").val().substring(0,4));
					 
		});
		
		var regexAge = new RegExp("^[1]{1}[0-9]{10}$");
		/*对手机号进行匹配*/
		$(".ztcss").focus(function(){
								   
			$(".eisok3").empty();
			
			if(regexAge.test($(this).val())){
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;11位数字手机号</span>");
				bool = false;
			}
					   
		}).blur(function(){
				
				$(".eisok3").empty();
				
				if(regexAge.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
			
		});
		
		var regexEmail = new RegExp("^[a-zA-Z0-9]+@[a-zA-Z]{2,5}\\56{1}(com|cn)$");
		/*对email的匹配*/
		$(".eemail").focus(function(){
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
		
		/*给薪水增加事件*/
		$("span[id=esal1]").click(function(){
			
			var origin = parseInt($(".esal").val());
			var num;
			
			
				if(!isNaN(origin) && origin < 98999){
					num = eval(parseInt(new String($(".esal").val())) + parseInt($(this).text()));
				
				}if(isNaN(origin)){
					num = $(this).text();
				}
			
			$(".esal").val(num);
			
		
		});
		
		/*给工资做验证*/
		
		var regexEsal = new RegExp("^[0-9]{1,5}$");
		$(".esal").focus(function(){
			$(".eisok5").empty();
			
			if(regexEsal.test($(this).val())){
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;数字</span>");
				bool = false;
			}
		}).blur(function(){
			$(".eisok5").empty();
				
			if(regexEsal.test($(this).val())){
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;×</span>");
				bool = false;
			}
		});
		
		$("span[id=esal1]").click(function(){
				$(".eisok5").empty();
				$(".esal").after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
									   
		});
		
	});
	
	function pdsub(){
	
		return bool;
	}
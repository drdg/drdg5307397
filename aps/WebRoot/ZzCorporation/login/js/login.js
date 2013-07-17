// JavaScript Document
	var bool = false;
	
	$(function(){
		var regexName = new RegExp("^[\u4E00-\u9FA5]{2,10}$");
		/*对用户名*/
		$("#cname").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;2-10个汉字名</span>");
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
		
		var regexName2 = new RegExp("^[0-9]{1,15}$");
		/*对用户名*/
		$("#cpwd").focus(function(){
			
			$(".eisok1").empty();
			
			if(regexName2.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;请输入有效数字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok1").empty();
				
				if(regexName2.test($(this).val())){
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});	
		
		//异步发送邮件获取密码
		$("#getPwd").click(function(){
	
			var time = new Date();
			var url = "http://localhost:8088/aps/Branch?type=1&cname="+$("#cname").val()+"&t="+time.getTime();
			 $.get(url,null
			 		 ,function(date){
					alert(date);
	         })
		});
		
	});
	
	function doLogin(){
		
		if(bool){
			$("form").attr("action",$(":checked").val());
			window.close("login.jsp");
			return true;
		}else{
			return false;
		}
	}
	
	
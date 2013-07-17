// JavaScript Document
	var bool = false;
	
	$(function(){
		
		var regexName1 = new RegExp("^[\u4E00-\u9FA5]{3,10}$");
		/*线路名*/
		$("#rtname").focus(function(){
			
			$(".eisok2").empty();
			
			if(regexName1.test($(this).val())){
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;3-10个汉字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok2").empty();
				
				if(regexName1.test($(this).val())){
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok2' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});
		
		var regexName2 = new RegExp("^[\u4E00-\u9FA5]{3,15}$");
		/*线路名*/
		$("#rtspoint").focus(function(){
			
			$(".eisok1").empty();
			
			if(regexName2.test($(this).val())){
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok1' style='color:red; width:15px;'>&nbsp;3-15个汉字</span>");
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
		
		var regexName = new RegExp("^[0-9]{1,5}$");
		/*数字匹配*/
		$("#rpefpkg").focus(function(){
			
			$(".eisok3").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;1-10个数字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok3").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok3' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});
		
		$("#rpeopkg").focus(function(){
			
			$(".eisok6").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok6' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok6' style='color:red; width:15px;'>&nbsp;1-10个数字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok6").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok6' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok6' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});
		

		$("#repefpvo").focus(function(){
			
			$(".eisok4").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;1-10个数字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok4").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok4' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});
		
		

		$("#repovo").focus(function(){
			
			$(".eisok5").empty();
			
			if(regexName.test($(this).val())){
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
				bool = true;
			}else{
				$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;1-10个数字</span>");
				bool = false;
			}

		}).blur(function(){
				
				$(".eisok5").empty();
				
				if(regexName.test($(this).val())){
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;√</span>");
					bool = true;
				}else{
					$(this).after("<span class='eisok5' style='color:red; width:15px;'>&nbsp;×</span>");
					bool = false;
				}
		
		});
			   
	});
	
	function pdsub(){
		return bool;	
	}
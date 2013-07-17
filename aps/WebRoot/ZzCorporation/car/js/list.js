// JavaScript Document
	$(function(){
		
		$(".detail").toggle(
		
		function(){
			
			$(".bodyDiv table tr td[id=dne]").removeClass("dn").addClass("dncolor");
			$(".mainDiv").width(1400);
		},
		function(){
			$(".bodyDiv table tr td[id=dne]").addClass("dn");
			$(".mainDiv").width(1000);
		});
	
		$("#ssv td:gt(1)").click(function(){
			var soso = $(".sosotext"),sosotext = soso.val();
			
			soso.focus();
			
			if(sosotext.length > 0){
				
				if("¡¢" != sosotext.charAt(sosotext.length-1)){
					soso.val(sosotext+"¡¢"+$(this).text()+"£º");	
				}else{
					soso.val(sosotext+$(this).text()+"£º");	
				}
				
				
				
			}else{
				soso.val($(this).text()+"£º");	
			}
		});
	
		
	});
	
	function Pderr(){
		var soso = $(".sosotext"),sosotext = soso.val();
		if("¡¢" != sosotext.charAt(sosotext.length-1)){
			soso.val(sosotext+"¡¢");	
		}
		
		return true;
		
	}
	
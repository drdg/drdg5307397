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
		
	});
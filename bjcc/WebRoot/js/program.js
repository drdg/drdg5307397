$(function() { 
		$("#content a:gt(0)").hover(function() {
			$(this).addClass("seling");
		}, function() {
			$(this).removeClass("seling");
		});
		//为”全部“着色
		$(".f").attr("class", "seled");
		$("#key").bind("click", function(){
			var key = $.trim($("#key").text());
			if (key == "展开") {
				$("#slideDiv").show();
				$("#key").text("关闭");
				$("#key").parent().attr("class","zkyc");
				$("input[name='showFlag']").val("T");
			}
			if (key == "关闭") { 
				$("#key").text("展开");
				$("#key").parent().attr("class","Zkyc1");
				$("input[name='showFlag']").val("F");
				$("#slideDiv").stop().hide();
			} 
		});
		//获得序列号大于四的a标签、即条件中除时间外的其他标签
		$("#content a:gt(5)").click(function() { 
			//清除pageNo
			$("input[name='paginationBean.currentPage']").val("");
			var $dl=$(this).parents("dl");
			$dl.find("a").removeClass("seled");
			$(this).attr("class", "seled");
			var val1 = $(this).attr("id");
			var val2 = $(this).attr("fieldId");
			if (val2 == 1) {
				$("#sourceOrg").val(val1); 
			}else if (val2 == 2) {
				$("#form").val(val1);
			}else if (val2 == 3) {
				$("#source").val(val1);
			}else if (val2 == 4) {
				$("#audien").val(val1);
			}else if (val2 == 5) {
				$("#tag").val(val1);
			}
			$("#proForm").submit();
		});
		//条件-时间的事件绑定
		$("#content dl:first a").click(function() { 
			//清除pageNo
			$("input[name='paginationBean.currentPage']").val("");
			var val1 = $(this).html();  
			$("#date").val(val1); 
			$("#proForm").submit();
			
		});
		//重置按钮事件绑定
		$("#reset").click(function(){
			$(":hidden[id]").val("");
			$("#proForm").submit();
		});
		//搜索事件绑定
		$("#search").click(function(){
			$(":hidden[id]").val("");
			$("#proForm").submit();
		});
		$("#keyword").bind("keydown",function(event){
			if(13 == event.keyCode){
				$(":hidden[id]").val("");
				$("#proForm").submit();
			}
		});
		//保留颜色 
		//来源机构不为空时，设定来源机构的选中项
		setSelItem($("#sourceOrg").val());
		//征集来源
		setSelItem($("#source").val());
		//媒体类型
		setSelItem($("#form").val());
		//标签
		setSelItem($("#tag").val());
		//学习对象
		setSelItem($("#audien").val());
		//设定日期的选中项
		setDateSelItem();
	});
//设定检索条件的选中项
function setSelItem(selId){
	if(null!=selId && ""!=selId) { 
		$("#" + selId).closest("dl").find("a").removeClass("seled");
		$("#" + selId).attr("class", "seled");
	}
}
//设定检索条件日期的选中项
function setDateSelItem(){
	var date=$("#date").val();
	if(date!=null&&date!=""){
		$("#content dl:first a").removeClass("seled");
		$("#content dl:first a:contains("+ date +")").attr("class", "seled"); 
	} 
}
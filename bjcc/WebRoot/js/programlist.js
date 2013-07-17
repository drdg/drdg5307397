$(function() {
	$("#filter a").hover(function() {
		$(this).addClass("seling");
	}, function() {
		$(this).removeClass("seling");
	});
	// 清除pageNo
	$("#filter a:gt(4)").click(function() {
		$("input[name='paginationBean.currentPage']").val("");
	});
	$("#filter ul:first a").click(function() {
		$("input[name='paginationBean.currentPage']").val("");
	});
	// 为”全部“着色
	$(".f").attr("class", "seled");
	// 获得序列号大于4的a标签
	$("#filter a:gt(4)").click(function() {
		
		var $ul=$(this).parents("ul");
		$ul.find("a").removeClass("seled");
		$(this).attr("class", "seled");
		var val1 = $(this).attr("id");
		var val2 = $(this).attr("fieldId");
		if (val2 == 1) {
			$("#sourceOrg").val(val1);
		}
		if (val2 == 2) {
			$("#form").val(val1);
		}
		if (val2 == 3) {
			$("#source").val(val1);
		}
		if (val2 == 4) {
			$("#audien").val(val1);
		}
		if (val2 == 5) {
			$("#tag").val(val1);
		}
		document.proForm.submit();
	});
	
	//条件-时间的事件绑定
	$("#filter ul:first a").click(function() { 
		var val1 = $(this).html();  
		$("#date").val(val1); 
		$("#proForm").submit();
		
	});
	
	//搜索事件绑定
	$("#search").click(function(){
		$(":hidden[id]").val("");
		$("#proForm").submit();
	});
	
	//重置按钮事件绑定
	$("#reset").click(function(){
		$(":hidden[id]").val("");
		$("#proForm").submit();
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
		$("#" + selId).closest("ul").find("a").removeClass("seled");
		$("#" + selId).attr("class", "seled");
	}
}
//设定检索条件日期的选中项
function setDateSelItem(){
	var date=$("#date").val();
	if(date!=null&&date!=""){
		$("#filter ul:first a").removeClass("seled");
		$("#filter ul:first a:contains("+ date +")").attr("class", "seled"); 
	} 
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	$(function(){
		var currentPage = '${paginationBean.currentPage}';
		var pageSize = '${paginationBean.pageSize}';
		setReqPagi(currentPage,pageSize);
		$("form:eq(0)").bind("submit",function(){
			if("1"!=$("#pagiReqFlag").val()){
				$("input[name='paginationBean.currentPage']").val("1");
			}
		});
	});
	
	function refreshPageNo(pageNo){ 
		$("input[name='paginationBean.currentPage']").val(parseInt(pageNo));
		$("#pagiReqFlag").val("1");
		$("form:eq(0)").submit();
	}
	
	function setReqPagi(pageNo,pageSize){
		var form = $("form:eq(0)");
		if(0==form.size()){
			form = $("<form>");
			$("body").append(form);
		}
		if(''==pageNo){
			pageNo=1;
		}
		if(''==pageSize){
			pageSize=5;
		}
		form.attr("method","post");
		form.append($("<input type='hidden'>").attr("name","paginationBean.currentPage").val(pageNo));
		form.append($("<input type='hidden'>").attr("name","paginationBean.pageSize").val(pageSize));
	}
</script>
<div style="font-size:12px;">
	<s:if test="1==paginationBean.currentPage">
		<strong><img src="images/icon5.gif" width="13" height="7" />首 页</strong>｜
		<strong>上一页</strong>｜
	</s:if>
	<s:else>
		<strong><img src="images/icon5.gif" width="13" height="7" />
			<a href="javascript:refreshPageNo('1')">首 页</a> </strong>｜
		<strong>
			<a href="javascript:refreshPageNo('<s:property value="paginationBean.currentPage-1"/>')">上一页</a>
		</strong>｜
	</s:else>
	<s:if test="paginationBean.currentPage>=paginationBean.totalPage">
		<strong>下一页</strong>｜
		<strong>尾 页</strong>
	</s:if>
	<s:else>
		<strong>
			<a href="javascript:refreshPageNo('<s:property value="paginationBean.currentPage+1"/>')">下一页</a>
		</strong>｜
		<strong>
			<a href="javascript:refreshPageNo('<s:property value="paginationBean.totalPage"/>')">尾 页</a>
		</strong> 
	</s:else>
	共 <s:property value="paginationBean.totalRecord" /> 条记录 共 <s:property value="paginationBean.totalPage" /> 页/第 <s:property value="paginationBean.currentPage" /> 页
   <input type="hidden" id="pagiReqFlag"/>
</div>
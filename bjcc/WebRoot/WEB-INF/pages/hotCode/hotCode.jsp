<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'hotCode.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel=stylesheet href="${pageContext.request.contextPath }/css/style.css" type="text/css"></link>
		<SCRIPT type="text/javascript" src="${pageContext.request.contextPath }/js/tab.js"></SCRIPT>

		<style type="text/css">
			.style2 {
				color: #990100
			}
			
			.style3 {
				color: #9B0101
			}
			
			.style4 {
				color: #FE1F1A
			}
			
			.style5 {
				color: #F61C1B
			}
			
			.style6 {
				color: #666666
			}
			
			.style7 {
				color: #970102
			}
			
			.style8 {
				font-size: 16px
			}
		</style>
	</head>

	<body>
		<div class="wzgg" style="height: 170px; margin-top: 0px; border: 0px;">
			<div class="wzgg_tt" id="menu4">
				<div class="ccrc_tt_1">
					<img src="images/sc_icon.gif" />
					长城热词
				</div>
				<div class="ccrc_tt_2" id="menu4">
					<ul>
						<s:iterator var="hotCode" value="hotCodeList" id="name"
							status="st">
							<s:if test="#st.last">
								<s:if test="(#st.index+1)>9">
									<li>
										<a class="hover" onmousemove="setTab(4,0)">1</a>
									</li>
									<li>
										<a onmousemove="setTab(4,1)">2</a>
									</li>
								</s:if>
								<s:else>
									<li>
										<a class="hover" onmousemove="setTab(4,0)">1</a>
									</li>
								</s:else>
							</s:if>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="ccrc_ct" id="main4">
				<ul>
					<p>
						<s:iterator var="hotCode" value="hotCodeList" id="name" status="st">
							<s:if test="(#st.index)==0">
								<a target="_blank" href="<s:property value="url"/> " target="_blank"
									class="purple"> <s:property value="name" /> </a>
							</s:if>
							<s:if test="(#st.index)==1">
								<a target="_blank" href="<s:property value="url"/> " target="_blank" class="red">
									<s:property value="name" /> </a>
							</s:if>
							<s:if test="(#st.index)==2">
								<a target="_blank" href="<s:property value="url"/> " class="orange"
									target="_blank"> <s:property value="name" /> </a>
					</p>
					<p>
						</s:if>

						<s:if test="(#st.index)==3">
							<a target="_blank" href="<s:property value="url"/> " class="red size12"
								target="_blank"> <s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==4">
							<a target="_blank" href="<s:property value="url"/> " class="blue" target="_blank">
								<s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==5">
							<a target="_blank" href="<s:property value="url"/> " class="red" target="_blank">
								<s:property value="name" /> </a>
					</p>
					<p>
						</s:if>

						<s:if test="(#st.index)==6">
							<a target="_blank" href="<s:property value="url"/> " target="_blank"
								class="green"> <s:property value="name" /> </a>
						</s:if>

						<s:if test="(#st.index)==7">
							<a target="_blank" href="<s:property value="url"/> " target="_blank" class="red">
								<s:property value="name" /> </a>
						</s:if>

						<s:if test="(#st.index)==8">
							<a target="_blank" href="<s:property value="url"/> " class="yellow size12"
								target="_blank"> <s:property value="name" /> </a>
						</s:if>
						</s:iterator>
					</p>

					<!--<s:if test="(#st.index+1)%3==0">
									<br />
								</s:if>
							-->
				</ul>
				<ul style="display: none;">
					<p>
						<s:iterator var="hotCode" value="hotCodeList" id="name"
							status="st">

							<s:if test="(#st.index)==9">
								<a target="_blank" href="<s:property value="url"/> " target="_blank"
									class="purple"> <s:property value="name" /> </a>
							</s:if>
							<s:if test="(#st.index)==10">
								<a target="_blank" href="<s:property value="url"/> " target="_blank" class="red">
									<s:property value="name" /> </a>
							</s:if>
							<s:if test="(#st.index)==11">
								<a target="_blank" href="<s:property value="url"/> " class="orange"
									target="_blank"> <s:property value="name" /> </a>
					</p>
					<p>
						</s:if>
						<s:if test="(#st.index)==12">
							<a target="_blank" href="<s:property value="url"/> " target="_blank"
								class="red size12"> <s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==13">
							<a target="_blank" href="<s:property value="url"/> " target="_blank" class="blue">
								<s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==14">
							<a target="_blank" href="<s:property value="url"/> " class="red" target="_blank">
								<s:property value="name" /> </a>
					</p>
					<p>
						</s:if>

						<s:if test="(#st.index)==15">
							<a target="_blank" href="<s:property value="url"/> " target="_blank"
								class="green"> <s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==16">
							<a target="_blank" href="<s:property value="url"/> " target="_blank" class="red">
								<s:property value="name" /> </a>
						</s:if>
						<s:if test="(#st.index)==17">
							<a target="_blank" href="<s:property value="url"/> " class="yellow size12"
								target="_blank"> <s:property value="name" /> </a>
						</s:if>

						</s:iterator>
					</p>

				</ul>
			</div>
		</div>

	</body>
</html>

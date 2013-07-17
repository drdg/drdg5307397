	
	/*****************************************
	 *本案例针对table开发					 *
	 *使用的时候给table一个					 *
	 *id=editTable							 *
	 *下面的数组是定义好的数据库字段		 	 *
	 *在使用jqAjax时候直接遍历carSub对象即可   *
	 *****************************************/
	
	$(function(){
		
		//定义好要传的数据字段
		var colmes = new Array("ctid","","cnickname","cname","csex","ctel","cemail","cbirthday","caddress");		
		//定义一个组装车用户装对象
		var carSub = "";
	
		var Einput = "<input type='text' style='background:transparent;border:0px;color:yellow;width:100px;'></input>";		   
		var regex = new RegExp("^[\u4E00-\u9FA5]+$");
		
		$("#editTable tr:gt(0) td:gt(1)").click(function(){
			
			var now_ = $(this).text();
		
			if($(this).children().val()==null){
				
				$(this).empty();
				$(this).append(Einput).focus();
				if(regex.test(now_)){
					$(this).children().focus().val(now_).css('width',now_.length*16);
				}else{
					$(this).children().focus().val(now_).css('width',now_.length*10);
				}
			}
			
		});
		
		
		$("#editTable tr:gt(0) td span[id='updateE']").click(function(){
				
				//清空原来存在的数据
				carSub = "";
				
				//获得id并装载
				carSub = "{\""+colmes[0]+"\":\""+$(this).attr("class")+"\",";

				//当点击修改时候，获得父元素，之后获得父元素以下的孩子元素
				var obj = $(this).parent().parent().children();
				
				for(var i = 2; i < obj.length - 1; i ++){
					
					//如果这个文本框的值是空说明这个文本框已经被input text取代
					if(obj.eq(i).text().length == ""){
						carSub += "\""+colmes[i]+"\":\""+obj.eq(i).children().val() + "\",";
					}else{
						carSub += "\""+colmes[i]+"\":\""+obj.eq(i).text() + "\",";	
					}
					
					//修改以后点击以后把文本框去掉
					obj.eq(i).text(obj.eq(i).children().val());	
					obj.eq(i).children().empty();
			    }
				//把数据最后多出来的点去掉,之后加上最后的括号，最后转换为对象用eval
				carSub = eval("("+carSub.substr(0,carSub.lastIndexOf(","))+"})");
				//异步向后台发送信息
				AjaxJq(carSub);
		});
		
		function AjaxJq(carSub){
			var time = new Date();
			var url = "http://localhost:8088/aps/Corporation?type=14&key=3&"+time.getTime();
			 $.get(url,
						{
					 		ctid:carSub["ctid"],
					 		cnickname:carSub["cnickname"],
					 		cname:carSub["cname"],
					 		csex:carSub["csex"],
					 		ctel:carSub["ctel"],
					 		cemail:carSub["cemail"],
					 		cbirthday:carSub["cbirthday"],
					 		caddress:carSub["caddress"]
						}
			 		 ,function(date){
					alert(date);
	         })
		}
		//2012年9月12日 08:33:38
		//当点击删除的时候，删除这个元素
		$("span[id=deleteE]").click(function(){
			
			var isDelete = confirm("确定删除（？）");
			//确定是否删除
			if(isDelete){
				
				$(this).parent().parent().empty();
				var url = "http://localhost:8088/aps/Corporation?type=14&key=2&deleteId="+$(this).attr("class");
				$.get(url,null,function(date){
					alert(date);
				});
				
			}
		});
		
		
		/*
		 *2012年9月12日 15:54:33加完批量删除
		 */
		 
		//定义一个变量，把想删除的id，一起组合到这个里面
		var witeDeleteNoS = "";
		
		//2012年9月12日 13:58:00
		//当用户鼠标滑动到多选框上的时候则把这个选取上
		$("table tr td input[type=checkbox]").mouseover(function(){
			
			if(!$(this).attr("checked")){
				$(this).attr("checked",true);
			}else{
				$(this).attr("checked",false);
			}
			
		});
		
		//当点击选取全部的时候，
		//第一次点击那么选取全部，
		//第二次点击则全部 不选取
		$("#isSelectAll").toggle(function(){						  
			$(this).text("全部清空");
			$("table tr td input[type=checkbox]").attr("checked",true);
		},function(){
			$(this).text("全部选取");
			$("table tr td input[type=checkbox]").attr("checked",false);
		});
		
		//当点击删除操作时候
		//var name=prompt("请输入您的名字","Bill Gates")
		$("#isDeleteChecked").click(function(){
			
			var mouseKey = prompt("请输入执行口令","");
			
			//当拿到口令口，讲进行异步提交，判断次口令是否正确
			if("tiger" == mouseKey){
				
				var Eobj = $("table tr td input[type=checkbox]");
				$.each(Eobj,function(i,n){
						//组装要删除的id
						if(n.checked){
							witeDeleteNoS += n.value + ",";	
							$("table tr td span[class="+n.value+"]").parent().parent().empty();
						}
								
				})
				
				alert("delete ok! 已删字段id："+witeDeleteNoS);
			}else{
				alert("口令错误")
			}
		
		
		});
	});
	
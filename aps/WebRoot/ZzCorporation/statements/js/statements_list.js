// JavaScript Document
	$(function(){
		
		$("#wbb").click(function(){
			
			var fileurl = $("#fileurl").val(),
				fileurlSave="",fileNum,fileurlNew="";

			
			while(fileurl.lastIndexOf("\\") > 0){
				fileNum = fileurl.indexOf("\\");
				fileurlSave += fileurl.substring(0,fileNum)+"/";
				fileurl = fileurl.substring((fileNum+1));
			}
			/*重组*/
			fileurlNew = fileurlSave + $("#filename").val() + $("#fileleix").val();
			
			/*写入*/
			writeFile(fileurlNew,$("#tta").val());
		});
		
		$("#2012").click(function(){
			var xxx = "本年度三亿收入，付哥很开心\r\nhttp://topic.csdn.net/u/20110331/23/f7ae08f2-5824-4162-8949-65e618fa5e82.html?47267";
			$("#tta").val(xxx);					  
		});
		
	});
	 
/*    
object.OpenTextFile(filename[, iomode[, create[, format]]])    
参数    
object    
必选项。object 应为 FileSystemObject 的名称。    
filename    
必选项。指明要打开文件的字符串表达式。    
iomode    
可选项。可以是三个常数之一：ForReading 、 ForWriting 或 ForAppending 。    
create    
可选项。Boolean 值，指明当指定的 filename 不存在时是否创建新文件。如果创建新文件则值为 True ，如果不创建则为 False 。如果忽略，则不创建新文件。    
format    
可选项。使用三态值中的一个来指明打开文件的格式。如果忽略，那么文件将以 ASCII 格式打开。    
设置    
iomode 参数可以是下列设置中的任一种：    
常数 值         描述    
ForReading 1 以只读方式打开文件。不能写这个文件。    
ForWriting 2 以写方式打开文件    
ForAppending 8 打开文件并从文件末尾开始写。    
  
format 参数可以是下列设置中的任一种：    
值              描述    
TristateTrue 以 Unicode 格式打开文件。    
TristateFalse 以 ASCII 格式打开文件。    
TristateUseDefault 使用系统默认值打开文件。    
*/     
   
//读文件     
function readFile(filename){     
var fso = new ActiveXObject("Scripting.FileSystemObject");     
var f = fso.OpenTextFile(filename,1);     
var s = "";     
while (!f.AtEndOfStream)     
s += f.ReadLine()+"\n";     
f.Close();     
return s;     
}     
   
//写文件     
function writeFile(filename,filecontent){     
    var fso, f, s ;     
    fso = new ActiveXObject("Scripting.FileSystemObject");        
    f = fso.OpenTextFile(filename,8,true);     
    f.WriteLine(filecontent);       
    f.Close();     
	alert('写入完成');     
}   
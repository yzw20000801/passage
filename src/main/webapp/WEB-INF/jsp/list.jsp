<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="css/index_work.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.2.min.js">
</script>
<script type="text/javascript">
function page(cpage){
	$("[name='cpage']").val(cpage);
	$('#page').submit();
} 
function fun1(){
	var arr=document.getElementsByName("ck")
	for(i=0;i<arr.length;i++){
		arr[i].checked=true;
	}
}
function fun2(){
	var arr=document.getElementsByName("ck")
	for(i=0;i<arr.length;i++){
		arr[i].checked=false;
	}
}
function fun3(){
	var arr=document.getElementsByName("ck")
	for(i=0;i<arr.length;i++){
		if(arr[i].checked==false){
			arr[i].checked=true;
		}else{
			arr[i].checked=false;
		}
	}
}
 function fun4(){
	var p=new Array()
	var arr=$(".bid:checked")
	for(i=0;i<arr.length;i++){
		type=arr[i].value
		p.push(type)
	}
	$.post('delete.do',{bids:p.toString()},function(obj){
		if (obj>0) {
			alert("删除成功，共删除了"+obj+"条数据")
			location.href="list.do"
		}
	},'json');
} 
</script>
<body>
<form id="page"  action="list.do" method="post">
	<input type="hidden" name="cpage" value="${page.pageNum }">
	姓名：<input type="text" name="bname" value="${map.bname }">
	<button>搜索</button>
</form>
<input type="button" value="添加"  onclick="location='toadd.do'">
<input type="button" value="批量删除"  onclick="fun4()">
<table>
	<tr>
		<td>
			<input type="button" value="全选" onclick="fun1()">
			<input type="button" value="全不选" onclick="fun2()">
			<input type="button" value="反选" onclick="fun3()">
		</td>
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>爱好</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="m">
	<tr>
		<td><input type="checkbox"  name="ck" class="bid" value="${m.bid}" ></td>
		<td>${m.bid}</td>
		<td>${m.bname}</td>
		<td>${m.age }</td>
		<td>${m.cnames}</td>
		<td><input type="button" value="修改"  onclick="location='toupdate.do?bid=${m.bid}'"></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="11">
			<input type="button"  value="上一页"  onclick="page('${page.pageNum-1}')">
			<input type="button"  value="下一页"  onclick="page('${page.pageNum+1}')">
			第${page.pageNum }/${page.pages}页
		</td>
	</tr> 
</table>
</body>
</html>
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
function fun1(){
		$.post('update.do',$("form").serialize(),function(obj){
			if(obj>0){
				alert("修改成功")
				location.href="list.do"
			}else{
				alert('修改失败');
			}
			},'json'
		); 
}
</script>
<body>
<form action=""  method="post">
<input type="hidden" name="bid"  value="${f.bid}"><br>
	名称：<input type="text" name="bname"  value="${f.bname}"><br>
	年龄：<input type="text" name="age"  value="${f.age}"><br>
	爱好：<br>
	<c:forEach items="${list}" var="t">
		<input type="checkbox"  name="cids" class="cid"  value="${t.cid }"
		<c:forEach items="${list2}" var="c">
				<c:if test="${t.cid==c }">checked</c:if>
		</c:forEach>  
		>${t.cname }
	</c:forEach><br>
	<input type="button"  value="修改" onclick="fun1()">
</form>
</body>
</html>
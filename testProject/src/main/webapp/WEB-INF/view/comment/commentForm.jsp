<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<!-- 		<label for="content">comment</label> -->
		<form name="commentForm" id="commentForm" method="get">
			<div>
				<div>
					<span><Strong>Comments</Strong></span><span id="coCnt"></span>
				</div>
				<div>
					<table class="table">
						<tr>
							<td><textarea style="width: 1100px" rows="3" cols="30"
									id="coContent" name="coContent" placeholder="댓글을 입력하세요"></textarea>
								<div>
									<a href='#' onClick="fn_comment('${list.get(0).boardNum }')"
										class="btn pull-right btn-success">등록</a>
								</div></td>
						</tr>
					</table>
				</div>
			</div>
			<input type="hidden" name="boardNum" id="boardNum"
				value="${list.get(0).boardNum }" />
		</form>
	</div>
	<div class="container">
		<form id="commentListForm" name="commentListForm" method="post">
			<div id="commentList">
<%-- 				<c:forEach items="${list }" var="comment"> --%>
<!-- 					<table> -->
<!-- 						<tr> -->
<%-- 							<th>${comment.coWriter }</th> --%>
<%-- 							<td><p style="width: 1100px">${comment.coContent }</p></td> --%>
<!-- 						</tr> -->
						
<!-- 					</table> -->
<%-- 				</c:forEach> --%>
			</div>
		</form>
	</div>
	
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
	/*
	*	댓글 등록하기(Ajax)
	*/
	function fn_comment(code){
// 		alert("start");
	$.ajax({
		type:'POST',
		url : "<c:url value='/comment/regist' />",
		data : $("#commentForm").serialize(),
		success : function(data){
		alert("success");
            if(data=="success")
            {
//                 getCommentList();
                $("#coContent").val("");
            }
        },
        error:function(request,status,error){
//             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
		
	});
}

	/**
	 * 초기 페이지 로딩시 댓글 불러오기
	 */
// 	$(function(){
	    
// 	    getCommentList();
	    
// 	});
	 
// 	/**
// 	 * 댓글 불러오기(Ajax)
// 	 */
// 	function getCommentList(){
	    
// 	    $.ajax({
// 	        type:'GET',
// 	        url : "<c:url value='/comment/commentList'/>",
// 	        dataType : "json",
// 	        data:$("#commentForm").serialize(),
// 	        contentType: "application/json; charset=UTF-8", 
// 	        success : function(data){
	            
// 	            var html = "";
// 	            var coNum = data.length;
	            
// 	            if(data.length > 0){
	                
// 	                for(i=0; i<data.length; i++){
// 	                    html += "<div>";
// 	                    html += "<div><table class='table'><h6><strong>"+data[i].coWriter+"</strong></h6>";
// 	                    html += data[i].coContent + "<tr><td></td></tr>";
// 	                    html += "</table></div>";
// 	                    html += "</div>";
// 	                }
	                
// 	            } else {
	                
// 	                html += "<div>";
// 	                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
// 	                html += "</table></div>";
// 	                html += "</div>";
	                
// 	            }
	            
// 	            $("#coNum").html(coNum);
// 	            $("#commentList").html(html);
	            
// 	        },
// 	        error:function(request,status,error){
// 	             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

// 	       }
	        
// 	    });
// 	}

</script>
	
</body>
</html>

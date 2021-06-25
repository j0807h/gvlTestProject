<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	var boardNum = '${board.boardNum}'; //게시글 번호
	
	/*
	*	댓글 등록하기(Ajax)
	*/
	function commentInsert(code){
// 		alert("start");
	$.ajax({
		type:'POST',
		url : "<c:url value='/comment/regist' />",
		data : $("#commentForm").serialize(),
		success : function(data){
// 		alert("success");
            if(data=="success")
            {
                getCommentList(); //댓글 작성 후 댓글 목록 reload
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
	$(document).ready(function(){
	    getCommentList();
	});
	 
	/**
	 * 댓글 불러오기(Ajax)
	 */
	function getCommentList(){
// 	alert("start");
	$.ajax({
		url : "<c:url value='/comment/commentList'/>",
		type : 'get',
		data : {'boardNum':boardNum},
		success : function(data){
			var a = '';
			$.each(data, function(key, value){
				a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom:15px;">'
				a += '<div class="commentInfo'+value.coNum+'">'+'댓글번호 : '+value.coNum+' / 작성자 : '+value.coWriter;
// 				a += '<a onclick ="commentUpdate('+value.coNum+',\''+value.coContent+'\');" >   / 수정 </a>';
				a += '<a onclick ="commentDelete('+value.coNum+');" style="color : blue;" > / 삭제 </a></div>';
// 				a += '<a onclick ="commentDelete('+value.coNum+',\''+value.boardNum+'\');" > / 삭제 </a></div>';
				a += '<div class="commentContent'+value.coNum+'"> <p> 내용 : '+value.coContent+'</p>';
				a += '<a onclick ="commentReply('+value.coNum+');" > [->답글] </a>';
				a += '</div></div>';
			});
// 			alert("오류없아");
			$(".commentList").html(a);
		}
	});
	
}
	
	/*
	*	댓글 삭제
	*/
	function commentDelete(coNum){
		$.ajax({
			url : '/comment/delete/'+coNum,
// 			url : boardNum+'/comment/delete/'+coNum,
			type : 'post',
			success : function(data){
				if(data == 1) getCommentList(boardNum); //댓글 삭제후 목록 출력
			},
			error : function(request,status,error){
				console.log(boardNum);
	             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
			
		});
		
	}
	
	/*
	 * 	대댓글
	 */



</script>
</body>
</html>
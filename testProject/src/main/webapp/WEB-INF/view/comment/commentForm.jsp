<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var boardNum = '${list.get(0).boardNum }'; //게시글 번호

$('[name=commentInsertBtn]').click(function(){
	var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
	commentInsert(insertData); //아래의 insert함수 호출
});
	function commentInsert(insertData){
		$.ajax({
			alert('1');
			url : '../comment/regist',
			type : 'post',
			data : insertData,
			success : function(data){
				alert('2');
				if(Data == 1) {
					alert('3');
					commentList(); //댓글 작성 후 댓글 목록 reload
					$('[name=coContent]').val('');
				}
			},
			error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		       }
		});
	}
</script>
</head>
<body>
    <div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="boardNum" value="${list.get(0).boardNum }"/>
               <input type="text" class="form-control" id="coContent" name="coContent" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>

</body>
</html>

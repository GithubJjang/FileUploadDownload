<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
	<meta charset="utf-8">
</head>
<body>
	<h2>파일 업로드</h2>
	
        <form id="uploadForm" action="/upload" method="post" enctype="multipart/form-data">
     	  
           <h4>단일 파일 업로드</h4>
           <input type="file" name="file">
                   	
           <h4>다중 파일 업로드</h4>
           <input type="file" multiple="multiple" name="files">
			
	   <input type="submit"/>
	</form>
<script>
    $(document).ready(function() {
    // 폼 전송을 막고 대신 Ajax 통신을 수행하는 함수
    $("#uploadForm").submit(function(e) {
        e.preventDefault(); // 기본 폼 전송 동작 막기
        
        // FormData 객체 생성
        var formData = new FormData(this);
        
        // Ajax 통신 설정
        $.ajax({
            url: '/upload', // 서버 업로드 처리 URL
            type: 'POST',
            data: formData,
            processData: false, // processData를 false로 설정하여 FormData 객체를 직접 전송
            contentType: false, // contentType을 false로 설정하여 파일 업로드용 설정이 제대로 유지되도록 함
            success: function(response) {
                // 서버로부터 받은 응답 처리
                console.log(response);
            },
            error: function(error) {
                // 에러 처리
                console.error(error);
            }
        });
    });
});

</script>
</body>
</html>
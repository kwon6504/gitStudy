// << 이 문장은 기존 window.onload=function(){ 를 jquery 식으로 줄여쓴 것임.						
// 대신 맨 아래 닫는 괄호들 주의.						
$(function() {						
	var xhr = new XMLHttpRequest();					
						
	//jqeury : 선택한 요소에 이벤트 핸들러 추가					
						
	// 아래 jquery 문은 다시 아래아래껄로 더 줄일 수 있음.					
	//$("#cat1").on("click", function() {					
						
	//아래 두번째 버튼 처리한거랑 비교 해보시오.. 방식을 다르게 처리 했음.					
	$(".cat1").click(function() {					
		// todo: 컨텍스트 패스에 맞춰 수정할 것				
		$.get("/api/catOne", function(data) { 				
						
		// * 주의 * 기존 xhr.open.. 식에서 jqeury $.get 				
		// 문법으로 바꾼 경우 이 코드 처리를 해야 에러가 안남.				
		var x = JSON.stringify(data);				
						
		var jo = JSON.parse(x);				
		$("#cat1_area").text("이름:" + jo.name + " 나이:" + jo.age);				
		});				
	});					
						
	//$("#cat2").on("click", function() {					
	$(".cat2").click(function() {					
		// HTTP 메서드와 요청 URL 설정. 				
		// todo: 컨텍스트 패스에 맞춰 수정할 것				
		xhr.open('GET', '/api/catTwo'); 				
		xhr.send(); // 요청 보내기				
		xhr.onload = function() {				
			if (xhr.status === 200) { // 응답 상태 확인			
				var j = xhr.responseText;		
				var jo = JSON.parse(j)		
				$("#cat2_area").text("이름:"+jo.name+" 나이:"+jo.age);		
			} else {			
				console.error(xhr.statusText); // 오류 메시지 출력		
			}			
		};				
	});					
						
});					
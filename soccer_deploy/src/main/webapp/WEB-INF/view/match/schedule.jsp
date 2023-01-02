<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>schedule</title>

<link
	href="/https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/fonts/icomoon/style.css">
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/jquery.fancybox.min.css">

<link rel="stylesheet" href="/css/bootstrap-datepicker.css">

<link rel="stylesheet" href="/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="/css/aos.css">

<link rel="stylesheet" href="/css/style.css">
<!-- 달력 위젯  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

</head>

<style>

/* --------------------- */
input[name='publeYear'] {
	text-align: center;
}
</style>


<body>

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>


	<div class="hero overlay">
		<div class="container">
			<div class="row align-items-center line_up_row">
				<div class="col-lg-12">
					<h1>경기 등록</h1>
					<form method="post" action="/match/schedule">
						<input type="hidden" id="writer" value="${loginUser.id}">
						<!-- 작성자 아이디 넘기기 -->
						<div class="write">
							<div>
								<input type="text" name="opteam" class="form-control board-subject" placeholder="상대팀">
								<!-- 제목 넘기기 -->
							</div>
						</div>
						<div class="write">
							<div>
								<label class="form-label mt-4">주소</label>
								<div class="address">
									<div class="addressForm">
										<input type="text" name="add1" class="form-control"	id="sample6_postcode" placeholder="우편번호" readonly="readonly">
										<input type="button" id="sample6_button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
									</div>

									<input type="text" name="add2" class="form-control"	id="sample6_address" placeholder="주소" readonly="readonly">
									<input type="text" name="add3" class="form-control"	id="sample6_detailAddress" placeholder="상세주소" readonly>
									<input type="text" class="form-control" style="display: none;" id="sample6_extraAddress" placeholder="참고항목">
 
								</div>
								<!-- 내용 넘기기 -->
							</div>
						</div>
						<div class="calForm"
							style="display: flex; margin-top: 5%; margin-bottom: 5%;">
							<input name="publeYear" autocomplete="off" readonly="readonly">
							<label class="label-form"
								style="color: white; margin-left: 20px;">시간 : </label> <input
								name="time" style="margin-left: 10px;" type="time"
								autocomplete="off">
						</div>
						<div>
							<label for="file" class="label-file">
								<div class="file-upload">이미지 업로드</div>
							</label> <span id="filenames">선택된 파일 없음</span> <input type="file"
								id="file" name="file" style="display: none;" accept="image/*" />
						</div>
						<div class="board-reg-btn">
							<button type="submit" class="btn btn-primary bt">등록</button>
							<a href="/match" class="btn btn-primary">목록</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>




	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/js/jquery-ui.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/jquery.stellar.min.js"></script>
	<script src="/js/jquery.countdown.min.js"></script>
	<script src="/js/bootstrap-datepicker.min.js"></script>
	<script src="/js/jquery.easing.1.3.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/jquery.fancybox.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>
	<script src="/js/jquery.mb.YTPlayer.min.js"></script>
	<script src="/js/main.js"></script>
	<!-- 달력위젯을 사용하기위한 script -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

	<script type="text/javascript">
		/* 달력 위젯 적용 */

		/* 설정 */
		const config = {
			dateFormat : 'y/mm/dd',
			showOn : "button",
			buttonText : "날짜 선택",
			prevText : '이전 달',
			nextText : '다음 달',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			yearSuffix : '년',
			changeMonth : true,
			changeYear : true
		}

		$(function() {
			$("input[name='publeYear']").datepicker(config);
		});
		
		//카카오 주소API를 사용하는 코드
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수
    
                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }
    
                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("sample6_extraAddress").value = extraAddr;
                    
                    } else {
                        document.getElementById("sample6_extraAddress").value = '';
                    }
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").removeAttribute("readonly")
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }

	</script>
</body>
</html>
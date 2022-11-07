<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#zero {
	position: relative;
	width: 1900px;
	height: 1500px;
}

#one {
	position: relative;
	display: flex;
	background: linear-gradient(45deg, rgb(204, 255, 229),
		rgb(102, 255, 178));
	width: 100%;
	height: 15%;
}

#one_one {
	width: 25%;
	height: 100%;
}

#one_two {
	width: 45%;
	height: 100%;
	padding-left: 7%;
}

#one_three {
	width: 30%;
	height: 100%;
}

#menu {
	position: relative;
	display: flex;
	width: 98%;
	height: 4%;
	margin-top: 1%;
	margin-left: 2%;
}

#menu_one {
	background: linear-gradient(45deg, rgb(204, 255, 255),
		rgb(255, 255, 255));
	width: 40%;
	height: 100%;
}

#menu_two {
	width: 60%;
	height: 100%;
}

#two {
	position: relative;
	display: flex;
	width: 100%;
	height: 50%;
}

#two_one {
	width: 25%;
	height: 100%;
	margin: 2%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding: 1%;
}

#two_two {
	width: 45%;
	height: 100%;
	margin: 2%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding: 1%;
}

#two_three {
	width: 30%;
	height: 100%;
	margin: 2%;
	border-radius: 30px;
	border-style: solid;
	border-color: rgb(224, 224, 224);
	padding: 1%;
}

#three {
	position: relative;
	display: flex;
	background: linear-gradient(45deg, rgb(102, 255, 178),
		rgb(204, 255, 229));
	transform: translateY(160px);
	width: 100%;
	height: 27%;
}

#three_one {
	width: 25%;
	height: 100%;
	margin: 2%;
}

#three_two {
	width: 45%;
	height: 100%;
	margin: 2%;
}

#three_three {
	width: 30%;
	height: 100%;
	margin: 2%;
}

#image1 {
	width: 450px;
	height: 180px;
	margin-left: 5%;
	margin-right: 5%;
	margin-top: 3.3%;
	filter: drop-shadow(5px 5px 5px #000);
	/* box-shadow: 5px 5px 5px #000; */
}
/*  <link rel="stylesheet" href="css/jquery.fancybox.min.css"> */
</style>
<body>


	<div id="zero">

		<div id="one">
			<div id="one_one"></div>
			<div id="one_two">
				<img src="title2.png" id="image1">
			</div>
			<div id="one_three"></div>
		</div>

		<div id="menu">
			<div id="menu_one">메뉴 | 예시1 | 예시2 | 예시3 | 예시4 | 예시5 |</div>
			<div id="menu_two"></div>
		</div>

		<div id="two">
			<div id="two_one">
				<jsp:include page="/WEB-INF/view/chat/chat_front.jsp" />
			</div>
			<div id="two_two">공지글, 경기일정글</div>
			<div id="two_three">
				<button>로그인</button><span><button>회원가입</button></span>
				
			</div>
		</div>

		<div id="three">
			<div id="three_one"></div>
			<div id="three_two">
				<b> 대표문의 02-933-5895 대표자 : 이민진 개인정보책임자 : 이민진 교육담당자: 코리아IT아카데미
					교육상담실 E-mail : koreais@koreaedugroup.com Fax: 02-933-5892 통신판매업번호 :
					제 2022-서울노원-0514 호 전국지점안내코리아IT아카데미는 전국 직영점으로 운영되고 있습니다. 지점 주소 전화번호
					사업자번호 학원등록번호 강남지점 1관 서울특별시 강남구 테헤란로 146 현익빌딩 3,4층 02-538-0021
					815-88-00171 서울강남 제2020-1호 강남지점 2관 서울특별시 강남구 테헤란로 26길 12 제일비전타워 13층
					02-538-0021 815-88-00171 서울강남 제2020-1호 신촌지점 서울특별시 마포구 서강로 136 아이비타워
					2,3층 02-313-7300 325-88-00678 제02201700141호 대구지점 대구광역시 중구 중앙대로 366
					반월센트럴타워 9,10층 053-710-5890 331-87-01210 제5698호 부산지점 부산광역시 부산진구 중앙대로
					668, 에이원프라자 4층 051-914-5890 835-87-02007 제4881호 인천지점 인천광역시 부평구 시장로
					7 M.H타워 5층 032-262-5890 333-87-02608 제4694호 대전지점 대전광역시 서구 둔산로52
					미라클빌딩 3층 042-369-5890 889-86-02332 제4858호 노원지점 서울특별시 노원구 상계로 1길 34
					5층 02-933-5890 174-86-02623 제2022-19호, 제2022-18호 </b>
			</div>
			<div id="three_three">
				<img src="title2.png" id="image1">
			</div>
		</div>

	</div>



</body>
</html>
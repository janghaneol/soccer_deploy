<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="utf-8">

<head>
  <title>Soccer &mdash; Website by Colorlib</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="/fonts/icomoon/style.css">

  <link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
  <link rel="stylesheet" href="/css/jquery-ui.css">
  <link rel="stylesheet" href="/css/owl.carousel.min.css">
  <link rel="stylesheet" href="/css/owl.theme.default.min.css">
  <link rel="stylesheet" href="/css/owl.theme.default.min.css">

  <link rel="stylesheet" href="/css/jquery.fancybox.min.css">

  <link rel="stylesheet" href="/css/bootstrap-datepicker.css">

  <link rel="stylesheet" href="/fonts/flaticon/font/flaticon.css">

  <link rel="stylesheet" href="/css/aos.css">

  <link rel="stylesheet" href="/css/style.css">



</head>

    <style>
        #zero {
            position: relative;
            width: 1500px;
            height: 100%;
            padding: 4%;
            padding-left: 16%;
            padding-top : 8%;
        }
         
        #deploy {
            position: relative;
            display: flex;
            width: 100%;
            height: 100%;
        }
        
        #deploy_one {
            width: 10%;
            height: 100%;
            margin: 2%;
            padding: 1%;
        }
        
        #deploy_two {
            width: 100%;
            height: 100%;
            border-radius: 30px;
            border-style: solid;
            border-color: rgb(224, 224, 224);
            padding-left: 5%;
        }
        
        #deploy_three {
            width: 10%;
            height: 100%;
            margin: 2%;
            padding: 1%;
        }
        
        #image1 {
            width: 300px;
            height: 400px;
        }
        
        #deploy_two_In {
            positon: relative;
            display: flex;
            flex-directory: column;
            width: 100%;
            height: 100%;
        }
        
        #deploy_two_In_one {
            width: 60%;
            height: 100%;
        }
        
        #deploy_two_In_two {
            width: 40%;
            height: 100%;
            padding-left: 5%;
            padding-bottom: 5%;
        }
        
        #to_center_footer {
            text-align: center;
        }
        .field-error {
          color: #ff0000;
        }
        .thead{
            text-align: center;
        }
        .th{
            display: table-cell;
            font-weight: bold;
            text-align: left;
        }
        #modUser{
            width: 150px;
            height: 30px;
        }
        #modUser2{
            width: 200px;
            height: 30px;
        }eight: 30px;
        }
        
        </style>
        
        <body>
        
        <jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>
        
            <!-- 여기까지가 기본구성.  -->
            <!-- 필요하면 지워도 되는데 책임은 못짐. -->
        
            <div id="zero">

                <div id="deploy">
                
                    <div id="deploy_two">
        
                        <div class="site-section">
                            <div class="container">
                                <div id="deploy_two_In">
                                    <div id="deploy_two_In_one">
                                        <h3 class="mb-3">회원 정보 수정</h3>
                                        <form action="/user/${loginUser.id}/modify" method="post">
                                        <input type="hidden" name="_method" value="put">
                                        <table class="table table-sm">
                                        <thead class="thead-dark">
                                                <tr>
                                                    <th scope="col" colspan="2" >
                                                        기본 정보
                                                    </th>
                                                </tr>
                                        </thead>
                                        
                                            <tbody>
                                                
                                                <tr class="text-white">
                                                    <th scope="row">이메일</th>
                                                    <td>${user.email}</td>
                                                    
                                                </tr>
        
                                                <tr class="text-white">
                                                    <th scope="row">나이</th>
                                                    <td>${user.age}</td>
                                                </tr>
                                                
                                                <tr class="text-white">
                                                    <th scope="row">이름</th>
                                                    <td>${user.name}</td>
                                                </tr>
                                                
                                                <tr class="text-white">
                                                    <th scope="row">등번호</th>
                                                    <td><input id="modUser" type="text" value="${user.backNum}" name="backNum"></td>
                                                </tr>
                                                
                                                <tr class="text-white">
                                                    <th scope="row">포지션</th>
                                                    <td>
                                                        <select id="modUser" name="position">
                                                            <option>FW</option>
							                                <option>MF</option>
							                                <option>DF</option>
							                                <option>GK</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                
                                                <tr class="text-white">
                                                    <th scope="row">주소</th> 
                                                    <td><input id="modUser2" name="add1" type="text" value="${user.address}">
                                                        <input type="button" id="sample6_button" onclick="sample6_execDaumPostcode()" value="수정"><br>
                                                        <input type="hidden" name="add2" style="width: 300px;"  name="add3" id="sample6_detailAddress" placeholder="상세주소"> 
                                                        <input type="text" class="form-control" style="display: none;" id="sample6_extraAddress" placeholder="참고항목">
                                                    </td>
                                                </tr>
                                            	
                                            </tbody>
                                        </table>
                                        
                                        <div class="logButton" style="display: inline;">
                                            <button class="btn btn-primary lg" type="submit">등록</button>
                                            <a href="/user/${loginUser.id}" class="btn btn-primary" style="margin-left: 10px;">취소</a>
                                        </div>
                                   </form>
                                </div>
                                <div id="deploy_two_In_two">
                                    <img src="/images/profile/${loginUser.imgFileName}" id="image1">
                                </div>
                           
                            </div>
                            
                        </div>
                    </div>
                    <div id="deploy_three"></div>
                </div>
        
            </div>
        </div>
        
        
      <script>
        
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
                            document.getElementById("modUser2").value = data.zonecode + ' ' + addr;
                            
                            // 커서를 상세주소 필드로 이동한다.
                            var a = document.getElementById("sample6_detailAddress");
                            a.type = "text";
                            document.getElementById("sample6_detailAddress").focus();
                        }
                    }).open();
                }

    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-migrate-3.0.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/bootstrap-datepicker.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/jquery.mb.YTPlayer.min.js"></script>


    <script src="js/main.js"></script>


</body>


</html>
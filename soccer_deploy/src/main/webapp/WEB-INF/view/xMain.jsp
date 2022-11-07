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

<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/jquery.fancybox.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">

<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">

</head>

<style>
#deploy{
    position : relative;
    display :flex;
 	
    width:1300px;
    height:750px;
    
    margin-top : 8%;
    margin-bottom : 8%;
}
#deploy_one{
    width: 60%;
    height : 100%;
    margin-right : 2%;
    
    /* border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224); */
    
    padding :1%;
}
#deploy_two{

	position : relative;
	display : flex;
	flex-direction : column;
	
    width: 20%;
    height:100%;
   
    
    border-radius : 30px;
    border-style : solid;
    border-color : rgb(224,224,224);
    
    padding :1%;
}
#deploy_two_one{

	width : 100%;
	height : 50%;
	
}

#deploy_two_two{

	width : 100%;
	height : 50%;
	
}
#to_center_footer{
	
	text-align : center;
}

#to_center_text{
	
	text-align : center;
}
#translateY1{
	
	transform : translateY(78px);
}

#translateY2{
	
	transform : translateY(270px);
}

</style>

<body>

	<div class="site-wrap">

	<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>


		<div class="hero overlay"
			style="background-image: url('images/bg_3.jpg');">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-5 ml-auto">
						<h1 class="text-white">World Cup Event</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Soluta, molestias repudiandae pariatur.</p>
						<div id="date-countdown"></div>
						<p>
							<a href="#" class="btn btn-primary py-3 px-4 mr-3">Book
								Ticket</a> <a href="#" class="more light">Learn More</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>





	<!-- 여기까지가 기본구성.  -->
	<!-- 필요하면 지워도 되는데 책임은 못짐. -->
	
<div class="container">
	
	<div id="deploy">
	
	<div id="deploy_one">
	
	
	
	<div id="translateY1">
	
	
	 <div class="container">
      <div class="row">
        <div class="col-lg-12">
          
          <div class="d-flex team-vs">
            <span class="score">4-1</span>
            <div class="team-1 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_1.png" alt="Image" class="img-fluid">
                <h3>LA LEGA <span>(win)</span></h3>
                <ul class="list-unstyled">
                  <li>Anja Landry (7)</li>
                  <li>Eadie Salinas (12)</li>
                  <li>Ashton Allen (10)</li>
                  <li>Baxter Metcalfe (5)</li>
                </ul>
              </div>
            </div>
            <div class="team-2 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_2.png" alt="Image" class="img-fluid">
                <h3>JUVENDU <span>(loss)</span></h3>
                <ul class="list-unstyled">
                  <li>Macauly Green (3)</li>
                  <li>Arham Stark (8)</li>
                  <li>Stephan Murillo (9)</li>
                  <li>Ned Ritter (5)</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    </div>
    
    
    
    
    
    
    
    <div id="translateY2">
	
	
	 <div class="container">
      <div class="row">
        <div class="col-lg-12">
          
          <div class="d-flex team-vs">
            <span class="score">4-1</span>
            <div class="team-1 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_1.png" alt="Image" class="img-fluid">
                <h3>LA LEGA <span>(win)</span></h3>
                <ul class="list-unstyled">
                  <li>Anja Landry (7)</li>
                  <li>Eadie Salinas (12)</li>
                  <li>Ashton Allen (10)</li>
                  <li>Baxter Metcalfe (5)</li>
                </ul>
              </div>
            </div>
            <div class="team-2 w-50">
              <div class="team-details w-100 text-center">
                <img src="images/logo_2.png" alt="Image" class="img-fluid">
                <h3>JUVENDU <span>(loss)</span></h3>
                <ul class="list-unstyled">
                  <li>Macauly Green (3)</li>
                  <li>Arham Stark (8)</li>
                  <li>Stephan Murillo (9)</li>
                  <li>Ned Ritter (5)</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    </div>
    
	
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	
    <%-- <div id="deploy_one">
    
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-12">
						<h1 class="text-white" align="center">Players</h1>
							
							<table class="table custom-table">
						<thead>
							<tr>
								<th>Player</th>
								<th>Position</th>
								<th>Goal</th>
								<th>Assist</th>
								<th>Matches</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="data" items="${컨트롤러에서 넘어옴}">
							
							<tr>데이터 받는 곳 주석으로 표시 해놨음. (데이터 사이 간격은 흰 줄로 표시됨.)
								<td><strong class="text-white">${data.데이터받는곳}</strong></td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
								<td class="text-white">${data.데이터받는곳}</td>
							</tr>
							
							</c:forEach>
						</tbody>

					</table>
					</div>
				</div>
			</div>
	
    
    </div> --%>
    
    
    <!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	<!-- 절대로 !!! 지우지 말것 !!!! 나중에 필요한 소스임. -->
	
	
	
	</div>
	
    	<div id="deploy_two">
    		
    		<div id="deploy_two_one">
    		
    			<div id="to_center_text">
    				<h1 class="text-white" align="center">Login</h1>
    			
    				<br>
    			
    				<div class="form-group">
        				<a href="xLogin"><button class="btn btn-primary py-3 px-5">Go To Login</button></a>
    				</div>
    			
    			</div>
    		
    		</div>
    		
    		<div id="deploy_two_two">
    			
    			<div id="to_center_text">
    				<h1 class="text-white" align="center">Chatting</h1>
    			
    				<br>
    			
    				<div class="form-group">
        				<a href="http://localhost:5000/"><button class="btn btn-primary py-3 px-5">Go To Chatting</button></a>
    				</div>
    			
    			</div>
    			
    		</div>
    		
    	
    	</div>
	</div>
	
	<!-- <div class="row justify-content-center">
        <div class="col-lg-7 text-center">
          <div class="custom-pagination">
            <a href="#">1</a>
            <span>2</span>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">7</a>
            <a href="#">8</a>
            <a href="#">9</a>
            <a href="#">10</a>
          </div>
        </div>
     </div> -->
     
     <!-- 버튼(페이징) -->
      
   
	
</div>


	<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>

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
<!DOCTYPE html>
<html>
<head>
<title>Soccer &mdash; Website by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script defer type="module" src="js/LineUpMake.js"></script>
<link rel="stylesheet" href="css/LineUpMake.css">


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

<script>
        function PrintDiv() {
            div = document.querySelector(".open");
            let setName = div.classList[1];
            console.log(setName);
            let date = "2021-12-01";//���߿� ��¥ �Է�
            html2canvas(div).then(function (canvas) {
                let myImage = canvas.toDataURL();
                downloadURI(myImage, `${date}_${setName}.png`);
            });
        }

        function downloadURI(uri, name) {
            let link = document.createElement("a")
            link.download = name;
            link.href = uri;
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(llink);
        }
    </script>

</head>

<body>

	<div class="site-wrap">

		<jsp:include page="/WEB-INF/view/include/header.jsp"></jsp:include>

		<div class="hero overlay"
			style="background-image: url('images/bg_3.jpg');">
			<div class="container">
				<div class="row align-items-center line_up_row">
					<div class="chan_set">
						<button type="button" class="make_first">1set</button>
						<button type="button" class="make_second">2set</button>
						<button type="button" class="make_third">3set</button>
						<button type="button" class="make_fourth">4set</button>
						<button type="button" class="img_sava" onclick="PrintDiv();">�̹���
							����</button>
					</div>

					<div class="lineUp" id="lineUp">

						<div class="dragin first_set open" id="dragin" data-quarter="1">
							<!-- quarter ���� ��� ���͹�ȣ -->
							<div class="form first empty st" id="player"></div>
							<div class="form first empty cf" id="player"></div>
							<div class="form first empty lm" id="player"></div>
							<div class="form first empty lcm" id="player"></div>
							<div class="form first empty rcm" id="player"></div>
							<div class="form first empty rm" id="player"></div>
							<div class="form first empty lb" id="player"></div>
							<div class="form first empty lcb" id="player"></div>
							<div class="form first empty rcb" id="player"></div>
							<div class="form first empty rb" id="player"></div>
							<div class="form first empty gk" id="player"></div>


						</div>

						<div class="dragin second_set close" id="dragin" data-quarter="2">
							<div class="form second empty st" id="player"></div>
							<div class="form second empty cf" id="player"></div>
							<div class="form second empty lm" id="player"></div>
							<div class="form second empty lcm" id="player"></div>
							<div class="form second empty rcm" id="player"></div>
							<div class="form second empty rm" id="player"></div>
							<div class="form second empty lb" id="player"></div>
							<div class="form second empty lcb" id="player"></div>
							<div class="form second empty rcb" id="player"></div>
							<div class="form second empty rb" id="player"></div>
							<div class="form second empty gk" id="player"></div>
						</div>

						<div class="dragin third_set close" id="dragin" data-quarter="3">
							<div class="form third empty st" id="player"></div>
							<div class="form third empty cf" id="player"></div>
							<div class="form third empty lm" id="player"></div>
							<div class="form third empty lcm" id="player"></div>
							<div class="form third empty rcm" id="player"></div>
							<div class="form third empty rm" id="player"></div>
							<div class="form third empty lb" id="player"></div>
							<div class="form third empty lcb" id="player"></div>
							<div class="form third empty rcb" id="player"></div>
							<div class="form third empty rb" id="player"></div>
							<div class="form third empty gk" id="player"></div>
						</div>

						<div class="dragin fourth_set close" id="dragin" data-quarter="4">
							<div class="form fourth empty st" id="player"></div>
							<div class="form fourth empty cf" id="player"></div>
							<div class="form fourth empty lm" id="player"></div>
							<div class="form fourth empty lcm" id="player"></div>
							<div class="form fourth empty rcm" id="player"></div>
							<div class="form fourth empty rm" id="player"></div>
							<div class="form fourth empty lb" id="player"></div>
							<div class="form fourth empty lcb" id="player"></div>
							<div class="form fourth empty rcb" id="player"></div>
							<div class="form fourth empty rb" id="player"></div>
							<div class="form fourth empty gk" id="player"></div>
						</div>

					</div>
					<div class="search">
						<button type="button" class="close_pop">X</button>

						<div class="col-lg-12">
							<h1>Players</h1>
							<div class="search-bar">
								<input type="text">
								<button type="button"></button>
							</div>
							<table class="table custom-table list">
								<thead>
									<tr>
										<th>No.</th>
										<th>�̸�</th>
										<th>��ȣ������</th>
										<th>������Ȳ</th>
									</tr>
								</thead>

								<tbody>
									<tr class="board player_list" id="play" data-num="5"
										data-name="jack" data-playId="1">
										<td id="pl" class="back_num"><strong>9</strong></td>
										<td id="pl" class="line_up_name">babo</td>
										<td id="pl" class="posit">FW</td>
										<td id="pl" class="quarter"><span class="quarter_one">1set</span><span
											class="quarter_two">2set</span><span class="quarter_three">3set</span><span
											class="quarter_four">4set</span></td>
									</tr>

									<tr class="board player_list" id="play" data-num="10"
										data-name="jack" data-playId="2">
										<td id="pl" class="back_num"><strong>7</strong></td>
										<td id="pl" class="line_up_name">ronaldo</td>
										<td id="pl" class="posit">FW</td>
										<td id="pl" class="quarter"><span class="quarter_one">1set</span><span
											class="quarter_two">2set</span><span class="quarter_three">3set</span><span
											class="quarter_four">4set</span></td>
									</tr>
								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/view/include/section.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/view/include/footer.jsp"></jsp:include>
	</div>
	<!-- .site-wrap -->

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
	<script src="js/html2canvas.js"></script>
</body>
</html>
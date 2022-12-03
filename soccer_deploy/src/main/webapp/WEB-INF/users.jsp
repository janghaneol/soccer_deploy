<%@page import="soccer.deploy.dto.noticeDTO"%>
<%@page import="soccer.deploy.dto.pageDTO"%>
<%@page import="soccer.deploy.dto.Params"%>
<%@page import="java.util.List"%>

<%@page import="soccer.deploy.service.noticeService"%>

<%@page import="soccer.deploy.service.ServiceFactoryImpl"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String searchType = request.getParameter("searchType");
if(searchType == null){ searchType = ""; }
String searchValue = request.getParameter("searchValue");
if(searchValue == null){ searchValue = ""; }
noticeService NoticeService = ServiceFactoryImpl.getInstance().getNoticeService();

// 페이징 처리를 위해 필요한 정보
// 전체검색개수, 한페이당 보여지는 목록 개수, 한 페이지당 보여지는 페이지 개수, 요청 페이지
int pageSize = 10;
int pageCount = 5;
int requestPage = 1;
String size = request.getParameter("pageSize");
if (size != null) { pageSize = Integer.parseInt(size);}

String selectPage = request.getParameter("requestPage");
if (selectPage != null) { requestPage = Integer.parseInt(selectPage);}

Params params = new Params(searchType, searchValue, pageSize, pageCount, requestPage);

List<noticeDTO> list = NoticeService.search(params);
int count = NoticeService.searchCount(searchType, searchValue);
// 페이징 처리

pageDTO paging = new pageDTO(params, count);
paging.build();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/css/basic.css">
<link rel="stylesheet" type="text/css" href="/css/pagination.css">
<style>
@media ( min-width : 1200px) {
	.container {
		max-width: 970px;
	}
}
</style>
</head>
<body>
  <!-- header start -->
  <div class="header">
    <h1>Looney's Portfolio Website</h1>
    <p>Resize the browser window to see the effect.</p>
  </div>

  <%--탑 네비게이션 시작 --%>
  <jsp:include page="/include/navigation.jsp" />
  <%--탑 네비게이션 끝 --%>
  <!-- header end -->

  <!-- main body start -->
  <div class="row">
    <div class="leftcolumn">
      <div class="w3-container">
        <div class="w3-center">
          <h3>회원 목록(총 <%=count %>명)</h3>
        </div>

        <!-- 검색폼 -->
        <div class="search">
          <form>
            <select name="type">
              <option value="">전체</option>
              <option value="id">아이디</option>
              <option value="name">이름</option>
            </select> <input type="text" name="value"
              placeholder="Search.."> <input type="submit"
              value="검색">
          </form>
        </div>

        <div class="w3-responsive w3-card-4">
          <table class="w3-table w3-striped w3-bordered">
            <thead>
              <tr class="w3-theme">
                <th>번호</th>
                <th>아이디</th>
                <th>이름</th>
                <th>이메일</th>
                <th>가입일자</th>
              </tr>
            </thead>
            <tbody>
            <%
            if(count != 0){
              int i = 1;
              for(noticeDTO NoticeDTO : list){
              %>
                <tr class="w3-white">
                  <td><%=NoticeDTO.getNotice_index() %></td>
                  <td><%=NoticeDTO.getNotice_title() %></td>
                  <td><%=NoticeDTO.getNotice_content() %></td>
                  <td><%=NoticeDTO.getNotice_date() %></td>
                  <td><%=NoticeDTO.getNotice_count() %></td>
                </tr>
              <%              
              } 
            }else {
              %>
              <tr><td colspan="5" style="color:red; text-align:center">회원이 존재하지 않습니다.</td></tr>              
              <%
            }
            %>
            </tbody>
          </table>
        </div>
        
        <div class="pagination">
        <%-- 처음으로 보여주기 여부 --%>
        <%
        if(paging.isShowFirst()){
        %>
          <a href="<%=paging.getQueryString(1)%>">처음으로</a>          
        <%
        }
        %>
        
        <%-- 이전목록 보여주기 여부 --%>
        <%
        if(paging.isShowPrevious()){
        %>
          <a href="<%=paging.getQueryString(paging.getPreviousStartPage())%>">&laquo;</a>          
        <%
        }
        %>
        
        <%-- 페이징 반복 --%>
        <%
        for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++){
          if(i == params.getRequestPage()){
          %>
            <a class="active"><%=i%></a>
          <%
          }else{
          %>
			<a href="<%=paging.getQueryString(i)%>"><%=i%></a>
        <%
          }
		}
        %>
        
        <%-- 다음목록 보여주기 여부 --%>
        <%
        if(paging.isShowNext()){
        %>
          <a href="<%=paging.getQueryString(paging.getNextStartPage())%>">&raquo;</a>          
        <%
        }
        %>
        
        <%-- 끝으로 보여주기 여부 --%>
        <%
        if(paging.isShowLast()){
        %>
          <a href="<%=paging.getQueryString(paging.getPageCount())%>">끝으로</a>          
        <%
        }
        %>
        </div>
      </div>
    </div>

    <!-- aside start -->
    <%-- 우측 메뉴 시작 --%>
    <jsp:include page="/include/aside.jsp" />
    <%-- 우측메뉴 끝 --%>
    <!-- aside end -->
  </div>
  <!-- main body end -->

  <!-- footer start -->

  <%-- 바닥글 시작--%>
  <jsp:include page="/include/footer.jsp" />
  <%-- 바닥글 끝--%>
  <!-- footer end -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나만의 일정 main</title>
		<link href="./resources/css/navi.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/customplan/customplan.css" rel="stylesheet" type="text/css" />
        <link href="./resources/css/footer.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
		<script src="./resources/js/customplan/customplan.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../include/header.jsp"></jsp:include>
			<div class="main">
				<!-- 메뉴바 아래 여백 -->
                <br>
                <br>
                <!-- 메인 이미지 + 나만의 일정만들기 박스 -->
                
                <div class="main-img">
                    <div class="main-img-box">
                        <br>
                        <p class="main-img-box-p1">OLLE THE JEJU와 함께</p>
                        <p class="main-img-box-p1">나만의 여행 일정을 만들어보세요</p>
                        <br>
                        <p class="main-img-box-p2">나만의 일정을 모두와 공유하는</p>
                        <p class="main-img-box-p2">함께하는 JEJU 여행!!</p>
                        <input class="btn btn-primary" type="button" value="나만의 일정 만들기" onclick="location.href='customplan_insert.do'">
                    </div>
                </div>

                <br><br><br><br>
                <div class="main_content">
                <div class="main-text">
                    <h4 style="font-family: 'cafe24_ddh'; font-size: 35px;">여행자들의 Plan</h4>
                    <div class="search">
                        <input class="form-control search1" type="search" placeholder="검색어 입력">
                        <button class="btn btn-outline-secondary search2" onclick="search();"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </div>
                </div>
                <br><br>

                <!-- 썸네일 -->
                <c:choose>
                	<c:when test="${empty planList }">
                		
                	</c:when>
                	<c:otherwise>
                		<div class="nail">
	                		<c:forEach var="plan" items="${planList }" varStatus="status">
	                				<div class="nail${status.count }">
				                        <a href="customplan_detail.do">
				                            <div class="nail_img">
				                                <div class="sleep">${plan.plan_term }</div>
				                            </div>
				                        </a>
				
					                    <div class="nail_inner">
					                        <p class="nail_title">${plan.plan_title }</p>
					                        <p class="nail_con_hash">${plan.plan_tendency } | 해쉬태그명</p>
					                        <span class="nail_like">추천수 | ${plan.plan_push }</span>
					                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                        <span class="nail_view">조회수 | ${plan.plan_views }</span>
					                        <hr style="margin-bottom: 0;">
					                        <div class="nail_hrt"><a href=""><i class="fa fa-heart-o fa-xs"></i></a> &nbsp; 찜하기</div>
					                    </div>
				                    </div>
	                		</c:forEach>
                		</div>
                	</c:otherwise>
                </c:choose>
                
                <br><br><br>
                
                <!-- 페이징 처리 -->
                <div class="paging">
					<c:if test="${paging.prev}">
		    			<a href="customplan_main.do?search=&page=${paging.beginPage-1}" class="prev" style="font-size:20px; margin-right: 5px;">prev</a>
					</c:if>
					<c:forEach begin="${paging.beginPage}" end="${paging.endPage }" step="1" var="index">
		    			<c:choose>
		        			<c:when test="${paging.page==index}">
		          			  	<span style="font-size: 20px; color: gray; margin: 5px;">${index}</span>
		        			</c:when>
		        			<c:otherwise>
		           			 	<a href="customplan_main.do?search=&page=${index}" class="index" style="font-size:20px; margin:5px;">${index}</a>
		        			</c:otherwise>
		    			</c:choose>
					</c:forEach>
					<c:if test="${paging.next}">
		   				<a href="customplan_main.do?search=&page=${paging.beginPage+1}" class="next" style="font-size:20px; margin-left: 5px;">next</a>
					</c:if>
				</div>
                <br><br><br><br><br>
			</div>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        #list-area {
            border: 1px solid white;
            text-align: center;
        }

        .outer a {
            color: white;
            text-decoration: none;
        }

        #search-area {
            margin-bottom: 24px;
        }
    </style>
</head>

<body>
    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판</h1>
        <br>

        <div id="search-area">
            <form action="search.bo" method="get">
                <input type="hidden" name="cpage" value="1">
                <select name="condition">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="keyword" value="${keyword }">
                <button type="submit">검색</button>
            </form>
        </div>

        <c:if test="${not empty condition }">
            <script>
                window.onload = function () {
                    const opt = document.querySelector("#search-area option[value=${condition}]");
                    opt.setAttribute("selected", true);
                }
            </script>
        </c:if>

        <table id="list-area">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="400">제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="b" items="${list }">
                    <tr>
                        <td>${b.boardNo }</td>
                        <td><a href="detail.bo?bno=${b.boardNo}">${b.boardTitle }</td>
                        <td>${b.boardWriter }</td>
                        <td>${b.count }</td>
                        <td>${b.createDate }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br><br>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />

        <div class="paging-area" align="center">
            <c:choose>
                <c:when test="${empty condition }">
                    <c:if test="${pi.currentPage ne 1 }">
                        <button
                            onclick="location.href='${contextPath}/list.bo?cpage=${pi.currentPage -1}'">&lt;</button>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:if test="${pi.currentPage ne 1 }">
                        <button
                            onclick="location.href='${contextPath}/search.bo?cpage=${pi.currentPage -1}&condition=${condition }&keyword=${keyword }'">&lt;</button>
                    </c:if>
                </c:otherwise>
            </c:choose>


            <c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
                <c:choose>
                    <c:when test="${p eq pi.currentPage }">
                        <button disabled>${p }</button>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${empty condition }">
                                <button onclick="location.href='${contextPath}/list.bo?cpage=${p}'">${p } </button>
                            </c:when>
                            <c:otherwise>
                                <button
                                    onclick="location.href='${contextPath}/search.bo?cpage=${p}&condition=${condition }&keyword=${keyword }'">${p
                                    } </button>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${empty condition }">
                    <c:if test="${pi.currentPage ne pi.maxPage }">
                        <button
                            onclick="location.href='${contextPath}/list.bo?cpage=${pi.currentPage +1}'">&gt;</button>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:if test="${pi.currentPage ne pi.maxPage }">
                        <button
                            onclick="location.href='${contextPath}/search.bo?cpage=${pi.currentPage +1}&condition=${condition }&keyword=${keyword }'">&gt;</button>
                    </c:if>
                </c:otherwise>
            </c:choose>

        </div>
        <br><br>
    </div>
</body>

</html>
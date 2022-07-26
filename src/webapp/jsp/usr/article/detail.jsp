<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="exam.article.dto.ArticleDto" %>

<%
ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<h1>게시물 상세페이지</h1>

<div>
    <% if ( article != null ) { %>
        <div>
            ID : <%=article.getId()%>
        </div>
        <div>
            TITLE : <%=article.getTitle()%>
        </div>
        <div>
            BODY : <%=article.getBody()%>
        </div>
    <% } %>
</div>

<a href=/usr/article/list/free>게시글 목록</a>
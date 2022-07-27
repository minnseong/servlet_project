<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/head.jspf"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 상세페이지</h1>

        <div>
            <div>
                ID : ${article.getId()}
            </div>
            <div>
                TITLE : ${article.getTitle()}
            </div>
            <div>
                BODY : ${article.getBody()}
            </div>
        </div>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>
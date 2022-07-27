package exam.article;


import exam.Rq;
import exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = articleService.articleList();

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void showDetail(Rq rq, Long id) {
        ArticleDto articleDto = articleService.findById(id);

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);
        rq.appendBody("%d번 게시물이 생성 되었습니다.".formatted(id));
        rq.appendBody("<br/>");
        rq.appendBody("<a href=/usr/article/list/free>게시글 목록</a>");
    }

    public void deleteArticle(Rq rq, Long id) {
        articleService.deleteArticle(id);

        rq.appendBody("%d번 게시물이 삭제되었습니다.".formatted(id));
        rq.appendBody("<br/>");
        rq.appendBody("<a href=/usr/article/list/free>게시글 목록</a>");
    }

    public void showModifyForm(Rq rq, Long id) {
        ArticleDto articleDto = articleService.findById(id);

        rq.setAttr("article", articleDto);
        rq.view("usr/article/modify");
    }

    public void doModify(Rq rq, long id) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        articleService.modifyArticle(id, title, body);
        rq.appendBody("%d번 게시물이 수정 되었습니다.".formatted(id));
        rq.appendBody("<br/>");
        rq.appendBody("<a href=/usr/article/list/free>게시글 목록</a>");
    }
}

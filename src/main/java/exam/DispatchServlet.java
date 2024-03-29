package exam;

import exam.article.ArticleController;
import exam.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);
        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        switch (rq.getActionPath()) {
            case "/usr/article/detail":
                articleController.showDetail(rq, rq.getPathVariable(5));
                break;
            case "/usr/article/list":
                articleController.showList(rq);
                break;
            case "/usr/article/write":
                articleController.showWrite(rq);
                break;
            case "/usr/member/login":
                memberController.showLogin(rq);
                break;
            case "/usr/article/modify":
                articleController.showModifyForm(rq, rq.getPathVariable(5));
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);
        ArticleController articleController = new ArticleController();

        switch (rq.getActionPath()) {
            case "/usr/article/write":
                articleController.doWrite(rq);
                break;
            case "/usr/article/modify":
                articleController.doModify(rq, rq.getPathVariable(5));
                break;
            case "/usr/article/delete":
                articleController.deleteArticle(rq, rq.getPathVariable(5));
                break;
        }
    }
}

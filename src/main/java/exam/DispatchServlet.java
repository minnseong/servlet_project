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

        String url = req.getRequestURI();
        switch (url) {
            case "/usr/article/list/free":
                articleController.showList(rq);
                break;
            case "/usr/article/write/free":
                articleController.showWrite(rq);
                break;
            case "/usr/member/login":
                memberController.showLogin(rq);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);
        ArticleController articleController = new ArticleController();

        String url = req.getRequestURI();
        switch (url) {
            case "/usr/article/write/free":
                articleController.doWrite(rq);
                break;
        }
    }
}

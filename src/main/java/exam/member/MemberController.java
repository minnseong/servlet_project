package exam.member;

import exam.Rq;

public class MemberController {
    public void showLogin(Rq rq) {
        rq.appendBody("로그인");
    }
}

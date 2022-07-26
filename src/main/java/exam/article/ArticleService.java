package exam.article;

import exam.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> articleList() {
        return articleRepository.findAll();
    }

    public ArticleDto findById(Long id) {
        return articleRepository.findById(id);
    }
}

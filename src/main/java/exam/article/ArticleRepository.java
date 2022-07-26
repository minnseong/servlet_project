package exam.article;

import exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private static List<ArticleDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;
    }

    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto articleDto = new ArticleDto(id, title, body);
        datum.add(articleDto);
        return id;
    }

    public List<ArticleDto> findAll() {
        return datum;
    }

    public ArticleDto findById(Long id) {
        for (ArticleDto articleDto : datum) {
            if (articleDto.getId() == id)
                return articleDto;
        }
        return null;
    }
}

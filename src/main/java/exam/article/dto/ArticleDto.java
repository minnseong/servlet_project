package exam.article.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String body;
}

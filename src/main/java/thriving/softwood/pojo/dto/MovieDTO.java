package thriving.softwood.pojo.dto;

import java.io.Serial;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import thriving.softwood.pojo.entity.Movie;

/**
 * @author ThrivingSoftwood
 */
@Data
@NoArgsConstructor
public class MovieDTO extends Movie {
    @Serial
    private static final long serialVersionUID = 1L;

    Float minScore;
    String movieReleaseYear;
    String sortType;
    Map<String, String> orderByClause;
}

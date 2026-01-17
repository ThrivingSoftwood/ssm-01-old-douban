package thriving.softwood.pojo.dto;

import java.io.Serial;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thriving.softwood.pojo.entity.Movie;

/**
 * @author ThrivingSoftwood
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieQryDTO extends Movie {
    @Serial
    private static final long serialVersionUID = 1L;

    Map<String, Boolean> orderByClause;
}

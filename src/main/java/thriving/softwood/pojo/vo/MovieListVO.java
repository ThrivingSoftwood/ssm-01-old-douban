package thriving.softwood.pojo.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
public class MovieListVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Movie> movies;

    Long count;
}

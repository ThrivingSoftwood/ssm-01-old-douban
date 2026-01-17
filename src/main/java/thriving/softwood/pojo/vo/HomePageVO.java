package thriving.softwood.pojo.vo;

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
public class HomePageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Movie> upcoming;
    private List<Movie> outNow;
    private List<Movie> boxOfficeRanking;
}

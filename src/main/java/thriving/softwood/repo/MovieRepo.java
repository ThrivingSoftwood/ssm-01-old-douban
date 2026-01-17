package thriving.softwood.repo;

import java.util.List;

import thriving.softwood.pojo.dto.MovieQryDTO;
import thriving.softwood.pojo.entity.Movie;

/**
 * @author 柳燊
 * @date 2026/01/16 14:54:35
 */
public interface MovieRepo {
    List<Movie> list(MovieQryDTO dto);
    //
    // List<Movie> listOrderByBoxOfficeDesc();
    //
    // List<Movie> listOrderByCommentCountDesc();
    //
    // List<Movie> listOrderByReleaseDateDesc();
    //
    // List<Movie> listOrderByScoreDesc();
}

package thriving.softwood.api;

import thriving.softwood.pojo.dto.MovieDTO;
import thriving.softwood.pojo.vo.HomePageVO;
import thriving.softwood.pojo.vo.MovieDetailVO;
import thriving.softwood.pojo.vo.MovieListVO;

/**
 * @author 柳燊
 * @date 2026/01/16 14:48:23
 */
public interface LoadMovieApi {
    HomePageVO loadHomePage();

    MovieListVO loadBySortType(MovieDTO dto);

    MovieDetailVO loadMovieDetailById(Integer movieId);
}

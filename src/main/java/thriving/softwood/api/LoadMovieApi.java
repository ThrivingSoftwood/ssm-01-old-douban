package thriving.softwood.api;

import thriving.softwood.pojo.vo.HomePageVO;
import thriving.softwood.pojo.vo.MovieListVO;

/**
 * @author 柳燊
 * @date 2026/01/16 14:48:23
 */
public interface LoadMovieApi {
    HomePageVO loadHomePage();

    MovieListVO loadBySortType(String order);
}

package thriving.softwood.api;

import static thriving.softwood.common.enums.MovieSortTypeEnum.getBySortType;
import static thriving.softwood.common.enums.MovieStateEnum.OUT_NOW;
import static thriving.softwood.common.enums.MovieStateEnum.UPCOMING;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thriving.softwood.pojo.dto.MovieQryDTO;
import thriving.softwood.pojo.entity.Movie;
import thriving.softwood.pojo.vo.HomePageVO;
import thriving.softwood.pojo.vo.MovieListVO;
import thriving.softwood.repo.MovieRepo;

/**
 * @author 柳燊
 * @date 2026/01/16 14:48:23
 */
@Service
public class LoadMovieSvc implements LoadMovieApi {

    MovieRepo movieRepo;

    @Autowired
    public LoadMovieSvc(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public HomePageVO loadHomePage() {
        HomePageVO vo = new HomePageVO();
        MovieQryDTO dto = new MovieQryDTO();
        dto.setMovieState(UPCOMING.code());
        vo.setUpcoming(movieRepo.list(dto));
        dto.setMovieState(OUT_NOW.code());
        List<Movie> list = movieRepo.list(dto);
        vo.setOutNow(list);
        vo.setBoxOfficeRanking(
            list.stream().sorted(Comparator.comparing(Movie::getMovieBoxOffice).reversed()).toList());
        return vo;
    }

    @Override
    public MovieListVO loadBySortType(String sortType) {
        MovieListVO vo = new MovieListVO();
        MovieQryDTO dto = new MovieQryDTO();
        dto.setMovieState(OUT_NOW.code());
        List<Movie> list = movieRepo.list(dto);
        switch (getBySortType(sortType)) {
            case BY_POPULARITY:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieCommentCount).reversed()).toList();
                break;
            case BY_RELEASE_DATE:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieReleaseDate).reversed()).toList();
                break;
            case BY_SCORE:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieScore).reversed()).toList();
                break;
            default:
                break;
        }
        vo.setMovies(list);
        vo.setCount(Long.valueOf(list.size()));
        return vo;
    }

}

package thriving.softwood.controller;

import static thriving.softwood.common.enums.RespCodeEnum.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thriving.softwood.api.LoadMovieApi;
import thriving.softwood.common.result.Result;
import thriving.softwood.pojo.vo.HomePageVO;
import thriving.softwood.pojo.vo.MovieListVO;

/**
 * @author 柳燊
 */
@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    LoadMovieApi loadMovieApi;

    @Autowired
    public void setMovieApi(LoadMovieApi loadMovieApi) {
        this.loadMovieApi = loadMovieApi;
    }

    @RequestMapping("/loadHomePage")
    public Result<HomePageVO> loadHomePage() {
        try {
            return Result.success(loadMovieApi.loadHomePage());
        } catch (Exception e) {
            return Result.error(INTERNAL_SERVER_ERROR.code(), e.getLocalizedMessage());
        }
    }

    @RequestMapping("/loadMovieList")
    public Result<MovieListVO> loadMovieList(String sortType) {
        try {
            return Result.success(loadMovieApi.loadBySortType(sortType));
        } catch (Exception e) {
            return Result.error(INTERNAL_SERVER_ERROR.code(), e.getLocalizedMessage());
        }
    }
}

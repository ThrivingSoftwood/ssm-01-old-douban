package thriving.softwood.api;

import static thriving.softwood.common.enums.MovieSortTypeEnum.getBySortType;
import static thriving.softwood.common.enums.MovieStateEnum.OUT_NOW;
import static thriving.softwood.common.enums.MovieStateEnum.UPCOMING;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thriving.softwood.pojo.dto.CommentDTO;
import thriving.softwood.pojo.dto.MovieDTO;
import thriving.softwood.pojo.dto.UserDTO;
import thriving.softwood.pojo.entity.Comment;
import thriving.softwood.pojo.entity.Movie;
import thriving.softwood.pojo.entity.User;
import thriving.softwood.pojo.vo.CommentVO;
import thriving.softwood.pojo.vo.HomePageVO;
import thriving.softwood.pojo.vo.MovieDetailVO;
import thriving.softwood.pojo.vo.MovieListVO;
import thriving.softwood.repo.CommentRepo;
import thriving.softwood.repo.MovieRepo;
import thriving.softwood.repo.UserRepo;

/**
 * @author 柳燊
 * @date 2026/01/16 14:48:23
 */
@Service
public class LoadMovieSvc implements LoadMovieApi {

    MovieRepo movieRepo;
    CommentRepo commentRepo;
    UserRepo userRepo;

    @Autowired
    public LoadMovieSvc(MovieRepo movieRepo, CommentRepo commentRepo, UserRepo userRepo) {
        this.movieRepo = movieRepo;
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
    }

    @Override
    public HomePageVO loadHomePage() {
        HomePageVO vo = new HomePageVO();
        MovieDTO dto = new MovieDTO();
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
    public MovieListVO loadBySortType(MovieDTO dto) {
        MovieListVO vo = new MovieListVO();
        dto.setMovieState(dto.getMovieState());
        List<Movie> list = movieRepo.list(dto);
        switch (getBySortType(dto.getSortType())) {
            case BY_POPULARITY:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieCommentCount).reversed()).toList();
                break;
            case BY_RELEASE_DATE:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieReleaseDate).reversed()).toList();
                break;
            case BY_SCORE:
                list = list.stream().sorted(Comparator.comparing(Movie::getMovieScore).reversed()).toList();
                break;
            case null:
                list = list;
                break;
            default:
                break;
        }
        vo.setMovies(list);
        vo.setCount(Long.valueOf(list.size()));
        return vo;
    }

    @Override
    public MovieDetailVO loadMovieDetailById(Integer movieId) {
        return new MovieDetailVO(getMovie(movieId), listCommentVO(movieId));
    }

    private Movie getMovie(Integer movieId) {
        MovieDTO dto = new MovieDTO();
        dto.setId(Long.valueOf(movieId));
        Movie movie = movieRepo.get(dto);
        return movie;
    }

    private @NonNull List<CommentVO> listCommentVO(Integer movieId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setMovieId(Long.valueOf(movieId));
        List<Comment> list = commentRepo.list(commentDTO);
        UserDTO userDTO = new UserDTO();
        Map<Long, List<Comment>> map = list.stream().collect(Collectors.groupingBy(Comment::getUserId));
        userDTO.setIds(map.keySet().stream().toList());
        List<User> users = userRepo.list(userDTO);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        List<CommentVO> commentVOList = map.entrySet().stream().flatMap(entry -> {
            Long userId = entry.getKey();
            List<Comment> userComments = entry.getValue();
            User user = userMap.get(userId);
            return userComments.stream().map(comment -> new CommentVO(comment, user));
        }).collect(Collectors.toList());
        return commentVOList;
    }

}

package thriving.softwood.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thriving.softwood.mapper.MovieMapper;
import thriving.softwood.pojo.dto.MovieQryDTO;
import thriving.softwood.pojo.entity.Movie;

/**
 * @author 柳燊
 */
@Repository
public class MovieRepoImpl implements MovieRepo {

    MovieMapper movieMapper;

    @Autowired
    public MovieRepoImpl(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> list(MovieQryDTO dto) {
        return movieMapper.list(dto);
    }
    //
    // private List<Movie> listOrderBy(Map<String, Boolean> map) {
    // List<Movie> result = new ArrayList<>();
    // }
    //
    // @Override
    // public List<Movie> listOrderByBoxOfficeDesc() {
    // Map<String, Object> map = new HashMap<>();
    // map.put("movieState", OUT_NOW.code());
    // map.put("orderBy", "movie_box_office desc");
    // return movieMapper.listByMap(map);
    // }
    //
    // @Override
    // public List<Movie> listOrderByCommentCountDesc() {
    // Map<String, Object> map = new HashMap<>();
    // map.put("movieState", OUT_NOW.code());
    // map.put("orderBy", "movie_comment_count desc");
    // return movieMapper.listByMap(map);
    // }
    //
    // @Override
    // public List<Movie> listOrderByReleaseDateDesc() {
    // Map<String, Object> map = new HashMap<>();
    // map.put("movieState", OUT_NOW.code());
    // map.put("orderBy", "movie_release_date desc");
    // return movieMapper.listByMap(map);
    // }
    //
    // @Override
    // public List<Movie> listOrderByScoreDesc() {
    // Map<String, Object> map = new HashMap<>();
    // map.put("movieState", OUT_NOW.code());
    // map.put("orderBy", "movie_score desc");
    // return movieMapper.listByMap(map);
    // }
}

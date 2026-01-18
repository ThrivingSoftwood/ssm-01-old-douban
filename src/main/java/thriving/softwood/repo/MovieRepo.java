package thriving.softwood.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thriving.softwood.mapper.MovieMapper;
import thriving.softwood.pojo.dto.MovieDTO;
import thriving.softwood.pojo.entity.Movie;

/**
 * @author 柳燊
 */
@Repository
public class MovieRepo {

    MovieMapper movieMapper;

    @Autowired
    public MovieRepo(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public Movie get(MovieDTO dto) {
        return movieMapper.get(dto);
    }

    public List<Movie> list(MovieDTO dto) {
        return movieMapper.list(dto);
    }

}

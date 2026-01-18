package thriving.softwood.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thriving.softwood.mapper.CommentMapper;
import thriving.softwood.pojo.dto.CommentDTO;
import thriving.softwood.pojo.entity.Comment;

/**
 * @author ThrivingSoftwood
 */
@Repository
public class CommentRepo {
    CommentMapper commentMapper;

    @Autowired
    CommentRepo(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<Comment> list(CommentDTO dto) {
        return commentMapper.list(dto);
    }
}

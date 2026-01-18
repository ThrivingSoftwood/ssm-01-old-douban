package thriving.softwood.pojo.dto;

import java.io.Serial;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import thriving.softwood.pojo.entity.Comment;

/**
 * @author ThrivingSoftwood
 */
@Data
@NoArgsConstructor
public class CommentDTO extends Comment {
    @Serial
    private static final long serialVersionUID = 1L;
    Map<String, String> orderByClause;
}

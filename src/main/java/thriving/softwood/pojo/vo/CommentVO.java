package thriving.softwood.pojo.vo;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thriving.softwood.pojo.entity.Comment;
import thriving.softwood.pojo.entity.User;

/**
 * @author ThrivingSoftwood
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    Comment comment;
    User commentUser;
}

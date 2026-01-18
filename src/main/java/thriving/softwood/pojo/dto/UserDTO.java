package thriving.softwood.pojo.dto;

import java.io.Serial;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import thriving.softwood.pojo.entity.User;

/**
 * @author ThrivingSoftwood
 */
@Data
@NoArgsConstructor
public class UserDTO extends User {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Long> ids;
    Map<String, String> orderByClause;
}

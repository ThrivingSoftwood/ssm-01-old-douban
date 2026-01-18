package thriving.softwood.api;

import thriving.softwood.pojo.dto.UserDTO;
import thriving.softwood.pojo.entity.User;

/**
 * @author ThrivingSoftwood
 */
public interface ManageUserApi {
    User getLoginUser(UserDTO dto);

    String addUser(UserDTO dto);
}

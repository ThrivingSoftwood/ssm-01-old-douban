package thriving.softwood.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thriving.softwood.mapper.UserMapper;
import thriving.softwood.pojo.dto.UserDTO;
import thriving.softwood.pojo.entity.User;

/**
 * @author ThrivingSoftwood
 */
@Repository
public class UserRepo {
    UserMapper userMapper;

    @Autowired
    UserRepo(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> list(UserDTO dto) {
        return userMapper.list(dto);
    }

    public Integer add(UserDTO dto) {
        return userMapper.add(dto);
    }
}

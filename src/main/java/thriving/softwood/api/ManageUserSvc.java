package thriving.softwood.api;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.hutool.v7.core.text.StrUtil;
import thriving.softwood.pojo.dto.UserDTO;
import thriving.softwood.pojo.entity.User;
import thriving.softwood.repo.UserRepo;

/**
 * @author ThrivingSoftwood
 */
@Service
public class ManageUserSvc implements ManageUserApi {
    UserRepo userRepo;

    public ManageUserSvc(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getLoginUser(UserDTO dto) {
        UserDTO tmpDTO = new UserDTO();
        tmpDTO.setUserName(dto.getUserName());
        List<User> list = userRepo.list(tmpDTO);
        if (CollectionUtils.isEmpty(list) || !StrUtil.equals(list.getFirst().getUserPwd(), dto.getUserPwd())) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public String addUser(UserDTO dto) {

        UserDTO tmpDTO = new UserDTO();
        tmpDTO.setUserName(dto.getUserName());
        if (!CollectionUtils.isEmpty(userRepo.list(tmpDTO))) {
            return "exists";
        }
        if (userRepo.add(dto) > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}

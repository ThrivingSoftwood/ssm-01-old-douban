package thriving.softwood.controller;

import static thriving.softwood.common.enums.RespCodeEnum.INTERNAL_SERVER_ERROR;
import static thriving.softwood.common.enums.RespCodeEnum.LOGIN_INVALID_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import thriving.softwood.api.ManageUserApi;
import thriving.softwood.common.result.Result;
import thriving.softwood.pojo.dto.UserDTO;
import thriving.softwood.pojo.entity.User;

/**
 * @author ThrivingSoftwood
 */
@RestController
@RequestMapping("/user")
public class UserController {
    ManageUserApi manageUserApi;

    @Autowired
    public UserController(ManageUserApi manageUserApi) {
        this.manageUserApi = manageUserApi;
    }

    @RequestMapping("/login")
    public Result login(UserDTO dto, HttpSession session) {
        try {
            User user = manageUserApi.getLoginUser(dto);
            if (null == user) {
                return Result.error(LOGIN_INVALID_USER.code(), LOGIN_INVALID_USER.cnDesc());
            }
            session.setAttribute("user", user);
            return Result.success(user);
        } catch (Exception e) {
            return Result.error(INTERNAL_SERVER_ERROR, e);
        }
    }

    @RequestMapping("/register")
    public Result register(UserDTO dto) {
        try {
            return Result.success(manageUserApi.addUser(dto));
        } catch (Exception e) {
            return Result.error(INTERNAL_SERVER_ERROR, e);
        }
    }
}

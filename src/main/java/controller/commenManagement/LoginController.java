package controller.commenManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;
import util.json.RestResult;
import util.json.ResultCode;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User rest = userService.getById(user.getId());
        if(user.getPassword().equals(rest.getPassword()) && user.getUserType()==user.getUserType()){
            session.setAttribute("user",rest);
            return new RestResult().setCode(ResultCode.SUCCESS).toString();
        }
        else {
            return new RestResult().setCode(ResultCode.FAIL).setMessage("用户名或密码错误").toString();
        }

    }

}

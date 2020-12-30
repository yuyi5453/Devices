package controller.commenManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;
import util.json.RestResult;
import util.json.ResultCode;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String register(User user){
        if(userService.getById(user.getId())!=null) {
            return new RestResult().setCode(ResultCode.FAIL).setMessage("用户重复").toString();
        }
        else{
            userService.save(user);
            return new RestResult().setCode(ResultCode.SUCCESS).setMessage("注册成功").toString();
        }
    }
}

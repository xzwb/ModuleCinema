package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/a/post/login/phoneNumber")
    @ResponseBody
    public Result loginByPhoneNumber(@RequestBody User user, HttpSession session) {
        Result result = loginService.loginServiceByPhoneNumber(user.getPhoneNumber(), user.getUserPassword());
        if (result.getState() == 200) {
            user = (User) result.getData();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(2*60*60);
        }
        return result;
    }

    @PostMapping("/a/post/login/userId")
    @ResponseBody
    public Result loginByUserId(@RequestBody User user, HttpSession session) {
        Result result = loginService.loginServiceByUserId(user.getUserId(), user.getUserPassword());
        if (result.getState() == 200) {
            user = (User) result.getData();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(2*60*60);
        }
        return result;
    }
}

package ModuleCinema.controller;

import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
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
@CrossOrigin(allowCredentials = "true")
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

    @PostMapping("/a/post/login/bossId")
    @ResponseBody
    public Result loginByBossId(@RequestBody Boss boss, HttpSession session) {
        Result result = loginService.loginServiceByBossId(boss.getBossId(), boss.getBossPassword());
        if (result.getState() == 200) {
            boss = (Boss) result.getData();
            session.setAttribute("boss", boss);
            session.setMaxInactiveInterval(2*60*60);
        }
        return result;
    }

    @PostMapping("/a/post/login/staffId")
    @ResponseBody
    public Result loginByStaffId(@RequestBody Staff staff, HttpSession session) {
        Result result = loginService.loginServiceByStaffId(staff.getStaffId(), staff.getStaffPassword());
        if (result.getState() == 200) {
            staff = (Staff) result.getData();
            session.setAttribute("staff", staff);
            session.setMaxInactiveInterval(2*60*60);
        }
        return result;
    }
}

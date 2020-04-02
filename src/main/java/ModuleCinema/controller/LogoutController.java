package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 注销
 */
@Controller
@CrossOrigin
public class LogoutController {
    @GetMapping("/a/get/user/logout")
    @ResponseBody
    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        Result result = new Result();
        result.setState(200);
        result.setMessage("已注销");
        return result;
    }

    @GetMapping("/a/get/boss/logout")
    @ResponseBody
    public Result bossLogout(HttpSession session) {
        session.removeAttribute("boss");
        Result result = new Result();
        result.setState(200);
        result.setMessage("已注销");
        return  result;
    }

    @GetMapping("/a/get/staff/logout")
    @ResponseBody
    public Result staffLogout(HttpSession session) {
        session.removeAttribute("staff");
        Result result = new Result();
        result.setState(200);
        result.setMessage("已注销");
        return result;
    }
}

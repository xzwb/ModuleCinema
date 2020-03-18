package ModuleCinema.controller;

import ModuleCinema.pojo.User;
import ModuleCinema.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam User user) {
        return loginService.loginService(user);
    }
}

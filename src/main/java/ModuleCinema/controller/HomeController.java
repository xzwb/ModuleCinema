package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/u/get/home")
    @ResponseBody
    public Result home(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return homeService.homeService(user);
    }
}

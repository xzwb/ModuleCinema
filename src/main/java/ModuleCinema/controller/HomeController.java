package ModuleCinema.controller;

import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/b/get/home/{page}")
    @ResponseBody
    public Result bossHome(HttpSession session, @PathVariable("page") int page) {
        Boss boss = (Boss) session.getAttribute("boss");
        return homeService.homeServiceBoss(boss, page);
    }

    @GetMapping("/s/get/home")
    @ResponseBody
    public Result staffHome(HttpSession session) {
        Staff staff = (Staff) session.getAttribute("staff");
        Result result = new Result();
        result.setData(200);
        result.setMessage("登陆成功");
        return result;
    }
}

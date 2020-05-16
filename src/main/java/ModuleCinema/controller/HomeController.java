package ModuleCinema.controller;

import ModuleCinema.dao.UserDao;
import ModuleCinema.pojo.Boss;
import ModuleCinema.pojo.Result;
import ModuleCinema.pojo.Staff;
import ModuleCinema.pojo.User;
import ModuleCinema.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(allowCredentials = "true")
public class HomeController {
    @Autowired
    HomeService homeService;

    @Autowired
    UserDao userDao;

    @GetMapping("/b/get/staff/{page}")
    @ResponseBody
    public Result getStaffs(@PathVariable("page") int page) {
        return homeService.getStaffs(page);
    }

    @GetMapping("/b/get/home")
    @ResponseBody
    public Result bossHome(HttpSession session) {
        Boss boss = (Boss) session.getAttribute("boss");
        return homeService.homeServiceBoss(boss);
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

    @GetMapping("/u/get/home")
    @ResponseBody
    public Result userHome(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Result result = new Result();
        result.setState(userDao.getHotPlayTotal());
        result.setMessage("用户主页");
        result.setData(user);
        return result;
    }
}

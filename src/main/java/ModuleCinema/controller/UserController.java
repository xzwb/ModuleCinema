package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(allowCredentials = "true")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 获取热门影片
     */
    @GetMapping("/u/hotPlay/{page}")
    @ResponseBody
    public Result getHotPlay(@PathVariable("page") int page) {
        return userService.getHotPlay(page);
    }
}

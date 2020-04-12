package ModuleCinema.controller;

import ModuleCinema.pojo.Result;
import ModuleCinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/u/search/play")
    @ResponseBody
    public Result searchPlay(@RequestBody Map<String, String> playName) {
        return userService.getPlayByName(playName.get("playName"));
    }
}
